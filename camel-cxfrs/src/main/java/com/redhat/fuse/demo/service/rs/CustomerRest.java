package com.redhat.fuse.demo.service.rs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.redhat.fuse.demo.model.Account;

@Path("/customerservice/")
public interface CustomerRest {
	
	// TODO Documented with swagger

    @POST
    @Path("/enrich")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Account enrich(Account customer);

    @GET
    @Path("/show")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    String show(@PathParam("message") String message, @PathParam("message2") String message2);
    
}
