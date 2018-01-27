package ru.llalive.dev.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("/annotations")
	public String injectTest(@HeaderParam("customHeader") String header,
			@MatrixParam("param") String matrixParam,
			@CookieParam("cookie") String cookie) {
		return "Header: " + header + " Matrix Param: " + matrixParam
				+ " Cookie: " + cookie;
	}
}
