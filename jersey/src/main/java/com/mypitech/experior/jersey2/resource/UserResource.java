package com.mypitech.experior.jersey2.resource;

import com.mypitech.experior.jersey2.bean.UserBean;
import com.mypitech.experior.jersey2.service.UserService;
import org.apache.log4j.Logger;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Shawn Wheeler on 9/13/2014.
 */
@Stateless
@Path("user")
public class UserResource {

    private final static Logger LOGGER = Logger.getLogger(UserResource.class.getName());
    @Context
    UriInfo uriInfo;
    @Inject
    private UserService service;

    @GET
    @Produces({"application/json"})
    @Path("read")
    public Response read(@QueryParam("identity") String identity) {
        try {
            return Response.ok(service.read(identity)).build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("update")
    public Response update(@QueryParam("identity") String identity, UserBean user) {
        try {
            service.update(identity, user);
            return Response.accepted().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("delete")
    public Response delete(@QueryParam("identity") String identity) {
        try {
            service.delete(identity);
            return Response.accepted().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("create")
    public Response create(UserBean user) {
        try {
            service.create(user);
            return Response.accepted().build();
        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
