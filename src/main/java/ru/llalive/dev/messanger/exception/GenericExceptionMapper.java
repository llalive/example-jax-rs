package ru.llalive.dev.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import ru.llalive.dev.messanger.model.ErrorMessage;

//@Provider - disabled to avoid all exceptions to be held by this mapper
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500, "http://dev.llalive.ru");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
	}

}
