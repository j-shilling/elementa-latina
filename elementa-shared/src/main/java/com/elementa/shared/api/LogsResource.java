package com.elementa.shared.api;

import javax.annotation.security.PermitAll;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(ApiPaths.LOGS)
@Produces(MediaType.APPLICATION_JSON)
public interface LogsResource {
	
	@PermitAll
	@Path("/{uid}")
	@POST
	void log (@PathParam("uid") int uid, String msg);

}
