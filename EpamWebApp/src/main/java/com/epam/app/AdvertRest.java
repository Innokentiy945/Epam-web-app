package com.epam.app;


import com.epam.model.Advert;
import com.epam.services.AdvertService;

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

@Path("/adverts")
public class AdvertRest {

    @GET
    @Path("{advertid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvert(@PathParam("advertid") Long id) {
        Advert advert = AdvertService.getAdvert(id);

        if (advert == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(advert).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllAdverts")
    public Response getAllAdverts() {
        Set<Advert> adverts = AdvertService.getAllAdverts();

        if (adverts == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(adverts).build();
    }

    @GET
    @Path("/user/{user_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdvertByUserId(@PathParam("user_id") Long id) {

        List<Advert> advert = AdvertService.getAdvertByUserId(id);

        if (advert == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.OK).entity(advert).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertAdvert(Advert advert) throws SQLException, ClassNotFoundException {
        boolean insertAdvert = AdvertService.insertAdvert(advert);

        if (!insertAdvert) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(Response.Status.CREATED).entity(true).build();
    }

    @DELETE
    @Path("{advertid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAdvert(@PathParam("advertid") Long id) {
        boolean result = AdvertService.deleteAdvert(id);

        if (!result) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.status(204).build();
    }


}


