package com.epam.app;

import com.epam.model.Advert;
import com.epam.model.User;
import com.epam.services.AdvertService;
import com.epam.services.UserService;


import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/users")
public class UserRest {

    @GET
    @Path("/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userid") Long id) {
        User user = UserService.getUser(id);

        if (user == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(user).build();
    }

    @GET
    @Path("/getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        Set<User> users = UserService.getAllUsers();

        if (users == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(users).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUser(User user) throws SQLException, ClassNotFoundException {
        boolean insertedUser = UserService.insertUser(user);

        if (insertedUser == false) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).entity(true).build();
    }

    @DELETE
    @Path("{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userid") Long id) {
        boolean result = UserService.deleteUser(id);

        if (!result) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(204).build();
    }


}
