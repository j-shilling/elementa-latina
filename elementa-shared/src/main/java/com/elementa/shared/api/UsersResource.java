package com.elementa.shared.api;

import java.util.Set;

import javax.annotation.security.PermitAll;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.elementa.shared.dto.User;
import com.elementa.shared.security.PermitAdmin;
import com.elementa.shared.security.PermitTeacher;
import com.elementa.shared.security.PermitUser;

@Path(ApiPaths.USERS)
@Produces(MediaType.APPLICATION_JSON)
public interface UsersResource {
	
	@PermitAll
	@POST
	@Path("/login")
	User login (@FormParam("username") String username, @FormParam("password") String password);
	
	@PermitAll
	@GET
	@Path("/autologin")
	User login (@HeaderParam ("credential") String credential);
	
	@PermitAdmin
	@PermitTeacher
	@GET
	@Path("/available/{username}")
	Boolean checkUsername (@HeaderParam("Authorization") String auth, @PathParam("username") String username);
	
	@PermitAdmin
	@PermitTeacher
	@GET
	@Path("/search")
	Set<User> get (@HeaderParam ("Authorization") String auth);
	
	@PermitAdmin
	@PermitTeacher
	@POST
	@Path("/get/{uid}")
	User get (@HeaderParam ("Authorization") String auth, @PathParam("uid") int uid);
	
	@PermitAdmin
	@PermitTeacher
	@GET
	@Path("/search/{text}")
	Set<User> get (@HeaderParam ("Authorization") String auth, @PathParam("text") String text);
	
	@PermitAdmin
	@PermitTeacher
	@POST
	Boolean create (@HeaderParam ("Authorization") String auth, User user);
	
	@PermitUser
	@POST
	@Path("/update/{uid}")
	User update (@HeaderParam ("Authorization") String auth, @PathParam ("uid") int uid, User user);
	
	@PermitUser
	@POST
	@Path("/update/password")
	Boolean update (@HeaderParam ("Authorization") String auth, @FormParam ("password") String password);
	
	@PermitAdmin
	@PermitTeacher
	@POST
	@Path("/delete/{uid}")
	Boolean delete (@HeaderParam ("Authorization") String auth, @PathParam ("uid") int uid);
	
	@PermitUser
	@POST
	@Path("/validate")
	Boolean validate (@HeaderParam ("Authorization") String auth,@FormParam("username") String username, @FormParam("password") String password);
	
	
}
