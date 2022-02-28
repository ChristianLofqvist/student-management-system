package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("")
    @POST
    public Response createTeacher(Teacher teacher) {
        teacherService.create(teacher);
        return Response.created(URI.create("/sms/teachers/" + teacher.getId()))
                .build();
    }

    @Path("{id}")
    @PUT
    public Response updateTeacher(Teacher teacher, @PathParam("id") Long id) {
        Teacher updatedTeacher = teacherService.update(teacher, id);
        return Response.ok(updatedTeacher)
                .build();
    }

    @Path("query")
    @GET
    public Response getTeachers(@QueryParam("lastName") String lastName) {
        List<Teacher> foundTeachers = teacherService.getByLastName(lastName);
        return Response.ok(foundTeachers)
                .build();
    }

    @Path("")
    @GET
    public Response getAllTeachers() {
        List<Teacher> foundTeachers = teacherService.getAll();
        return Response.ok(foundTeachers)
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTeacher(@PathParam("id") Long id) {
        teacherService.delete(id);
        return Response.ok()
                .build();
    }

    @Path("{id}")
    @GET
    public Response getTeacherById(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.getById(id);
        return Response.ok(foundTeacher)
                .build();
    }

    @Path("{id}")
    @PATCH
    public Response update(@PathParam("id") Long id, Teacher teacher) {
        Teacher patchedTeacher = teacherService.patch(teacher, id);

        return Response.ok(patchedTeacher)
                .build();
    }
}
