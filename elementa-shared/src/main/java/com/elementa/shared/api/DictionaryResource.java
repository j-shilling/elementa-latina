package com.elementa.shared.api;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.elementa.shared.dto.Paradigm;
import com.elementa.shared.security.PermitAdmin;

@Path(ApiPaths.DICTIONARY)
@Produces(MediaType.APPLICATION_JSON)
public interface DictionaryResource {

	@PermitAdmin
	@GET
	@Path("/init/@{pos}")
	Paradigm getParadigmFromUserInput(
			@HeaderParam("Authorization") String auth,
			@PathParam("pos") int partOfSpeech,
			@HeaderParam("input") String input);

}
