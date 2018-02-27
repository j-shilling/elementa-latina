package com.elementa.server.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;

import com.elementa.server.guice.ServerModule;
import com.elementa.shared.dto.User;
import com.elementa.shared.security.PermitAdmin;
import com.elementa.shared.security.PermitStudent;
import com.elementa.shared.security.PermitTeacher;
import com.elementa.shared.security.PermitUser;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Provider
public class SecurityInterceptor implements ContainerRequestFilter {
	
	@Singleton
	public static class MySecurityInterceptor implements ContainerRequestFilter {
	
		private static final String AUTHORIZATION_PROPERTY = "Authorization";
	    private static final ServerResponse ACCESS_DENIED = 
	    		new ServerResponse("Access denied for this resource", 401, new Headers<Object>());
	    private static final ServerResponse ACCESS_FORBIDDEN = 
	    		new ServerResponse("Nobody can access this resource", 403, new Headers<Object>());
	    
	    private final Authenticator authenticator;
	    
	    @Inject
	    public MySecurityInterceptor(
	    		Authenticator authenticator) {
	    	this.authenticator = authenticator;
	    }
	    
	    @Override
		public void filter(ContainerRequestContext requestContext) throws IOException {
	    	ResourceMethodInvoker methodInvoker = 
					(ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
	        Method method = methodInvoker.getMethod();
	        
	       if ( !method.isAnnotationPresent(PermitAll.class) ) {
	        	//Access denied for all 
	            if(method.isAnnotationPresent(DenyAll.class))
	            {
	                requestContext.abortWith(ACCESS_FORBIDDEN);
	                return;
	            }
	            
	            //Get request headers
	            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
	             
	            //Fetch authorization header
	            final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
	             
	            //If no authorization information present; block access
	            if(authorization == null || authorization.isEmpty())
	            {
	                requestContext.abortWith(ACCESS_DENIED);
	                return;
	            }
	             
	            Optional<User> result = this.authenticator.getUser(authorization.get(0));
	            if (result.isPresent()) {
	            	if (method.isAnnotationPresent(PermitUser.class)) {
	            		return;
	            	}
	            	
	            	User user = result.get();
	            	
	            	if (user.isAdmin()) {
	            		
	            		if (method.isAnnotationPresent(PermitAdmin.class))
	            			return;
	            		
	            	}
	            	
	            	if (user.isTeacher()) {
	            		
	            		if (method.isAnnotationPresent(PermitTeacher.class))
	            			return;
	            		
	            	}
	            	
	            	if (user.isStudent()) {
	            		
	            		if (method.isAnnotationPresent(PermitStudent.class))
	            			return;
	            		
	            	}
	            }
	            
	            requestContext.abortWith(ACCESS_DENIED);
	            
	        }
		}
    
	}
	
	private static final MySecurityInterceptor interceptor;
	
	static {
		Injector injector = Guice.createInjector(new AbstractModule() {

			@Override
			protected void configure() {
				this.install(new ServerModule());
				this.bind(MySecurityInterceptor.class);
			}
			
		});	
		
		interceptor = injector.getInstance(MySecurityInterceptor.class);
	}

	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		
		interceptor.filter(context);
		
	}
}
