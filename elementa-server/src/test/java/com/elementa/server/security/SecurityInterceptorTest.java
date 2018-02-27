package com.elementa.server.security;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Optional;


import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.elementa.server.security.SecurityInterceptor.MySecurityInterceptor;
import com.elementa.shared.dto.AccountRole;
import com.elementa.shared.dto.AccountType;
import com.elementa.shared.dto.User;
import com.elementa.shared.security.PermitAdmin;
import com.elementa.shared.security.PermitStudent;
import com.elementa.shared.security.PermitTeacher;
import com.elementa.shared.security.PermitUser;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;


@RunWith(Parameterized.class)
public class SecurityInterceptorTest {

	@Path("/test")
	@Produces("text/html; charset=UTF-8")
	public static class TestResource {
		
		@GET
		@Path("/all")
		@PermitAll
		public Response all() {
		    String result = "Hello World!";
		    return Response.status(200).entity(result).build();
		}
		
		@GET
		@Path("/user")
		@PermitUser
		public Response user() {
		    String result = "Hello World!";
		    return Response.status(200).entity(result).build();
		}
		
		@GET
		@Path("/admin")
		@PermitAdmin
		public Response admin() {
		    String result = "Hello World!";
		    return Response.status(200).entity(result).build();
		}
		
		@GET
		@Path("/teacher")
		@PermitTeacher
		public Response teacher() {
		    String result = "Hello World!";
		    return Response.status(200).entity(result).build();
		}
		
		@GET
		@Path("/student")
		@PermitStudent
		public Response student() {
		    String result = "Hello World!";
		    return Response.status(200).entity(result).build();
		}
		
		@GET
		@Path("/adminorteacher")
		@PermitAdmin
		@PermitTeacher
		public Response adminOrTeacher() {
		    String result = "Hello World!";
		    return Response.status(200).entity(result).build();
		}
		
	}
	
	public static class TestApplication extends Application {

		  public TestApplication() {}

		  @Override
		  public Set<Object> getSingletons() {
		    HashSet<Object> set = new HashSet<Object>();
		    set.add(new TestResource());
		    return set;
		  }
		  
		}
	
	public static class TestInterceptor implements ContainerRequestFilter {
		
		public static class TestAuthenticator implements Authenticator {

			@Override
			public Optional<User> getUser(String auth) {
				
				AccountType type = new AccountType();
				
				if (auth.contains("admin"))
					type.addRole(AccountRole.ADMIN);
				if (auth.contains("teacher"))
					type.addRole(AccountRole.TEACHER);
				if (auth.contains("student"))
					type.addRole(AccountRole.STUDENT);
				
				if (type.isAdmin() || type.isTeacher() || type.isStudent())
					return Optional.of(
								new User.UserBuilder()
									.setType(type)
									.build()
							);
				else
					return Optional.empty();
			}
			
		}
		
		private static final MySecurityInterceptor interceptor;
		static {
			Injector injector = Guice.createInjector(new AbstractModule() {

				@Override
				protected void configure() {
					this.bind(Authenticator.class).to(TestAuthenticator.class).asEagerSingleton();
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
	
	static final String APPLICATION_PATH = "/api";
	static final String CONTEXT_ROOT = "/";
	static final int port = 8888;
	
	static final int FINE = 200;
	static final int ACCESS_DENIED = 401;
	static final int ACCESS_FORBIDDEN = 403;
	
	private Server server;

	@Before
	public void setUp() throws Exception {
		
		ServletContextHandler context;
		ServletHolder restEasyServlet;
		ServletHolder defaultServlet;
		
		this.server = new Server(port);
		
		context = new ServletContextHandler(server, CONTEXT_ROOT);
		restEasyServlet = new ServletHolder(new HttpServletDispatcher());
		restEasyServlet.setInitParameter("resteasy.servlet.mapping.prefix", APPLICATION_PATH);
		restEasyServlet.setInitParameter("javax.ws.rs.Application",
				TestApplication.class.getName());
		restEasyServlet.setInitParameter("resteasy.providers", TestInterceptor.class.getName());
		
		context.addServlet(restEasyServlet, APPLICATION_PATH + "/*");
		
		defaultServlet = new ServletHolder(new DefaultServlet());
		
		context.addServlet(defaultServlet, CONTEXT_ROOT);
		
		this.server.start();
	}

	@After
	public void tearDown() throws Exception {
		this.server.stop();
		this.server.destroy();
	}
	
	final String resource;
	final String auth;
	final int code;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {
                	"/all",
                	"blank",
                	new Integer (FINE)
                },
                
                {
                	"/all",
                	"admin",
                	new Integer (FINE)
                },
                
                
                {
                	"/all",
                	"teacher",
                	new Integer (FINE)
                },
                
                {
                	"/all",
                	"student",
                	new Integer (FINE)
                },
                
                {
                	"/user",
                	"blank",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/user",
                	"admin",
                	new Integer (FINE)
                },
                
                
                {
                	"/user",
                	"teacher",
                	new Integer (FINE)
                },
                
                {
                	"/user",
                	"student",
                	new Integer (FINE)
                },
                
                {
                	"/admin",
                	"blank",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/admin",
                	"admin",
                	new Integer (FINE)
                },
                
                
                {
                	"/admin",
                	"teacher",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/admin",
                	"student",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/teacher",
                	"blank",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/teacher",
                	"admin",
                	new Integer (ACCESS_DENIED)
                },
                
                
                {
                	"/teacher",
                	"teacher",
                	new Integer (FINE)
                },
                
                {
                	"/teacher",
                	"student",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/student",
                	"blank",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/student",
                	"admin",
                	new Integer (ACCESS_DENIED)
                },
                
                
                {
                	"/student",
                	"teacher",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/student",
                	"student",
                	new Integer (FINE)
                },
                
                {
                	"/adminorteacher",
                	"blank",
                	new Integer (ACCESS_DENIED)
                },
                
                {
                	"/adminorteacher",
                	"admin",
                	new Integer (FINE)
                },
                
                
                {
                	"/adminorteacher",
                	"teacher",
                	new Integer (FINE)
                },
                
                {
                	"/adminorteacher",
                	"student",
                	new Integer (ACCESS_DENIED)
                }
                
        });
	}
	
	public SecurityInterceptorTest(String resource, String auth, Integer code) {
		this.resource = resource;
		this.auth = auth;
		this.code = code.intValue();
	}

	@Test
	public void testFilter() {
		String urlStr = "http://localhost:" + port + APPLICATION_PATH + "/test" + this.resource;
		try {
			URL url = new URL(urlStr);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty ("Authorization", this.auth);
			
			int responseCode = con.getResponseCode();
			if (responseCode != this.code)
				fail ("Response code = " + responseCode + " and wanted = " + this.code);
		} catch (Exception e) {
			fail (e.getMessage());
		}
	}

}
