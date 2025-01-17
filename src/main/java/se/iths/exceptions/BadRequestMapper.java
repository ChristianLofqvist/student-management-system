package se.iths.exceptions;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestMapper implements ExceptionMapper<BadRequestException> {

    @Override
    public Response toResponse(BadRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionsAsJson(e.getMessage(), Response.Status.BAD_REQUEST.getStatusCode()))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
