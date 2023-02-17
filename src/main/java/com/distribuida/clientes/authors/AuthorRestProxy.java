package com.distribuida.clientes.authors;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/authors")
@RegisterRestClient(configKey = "author")
public interface AuthorRestProxy {

    @GET
    @Path("/{id}")
    AuthorsCliente findById(@PathParam("id") Long id);

    @GET
    List<AuthorsCliente> findAll();

    @POST
    void insert(AuthorsCliente obj);

    @PUT
    @Path("/{id}")
    void update(AuthorsCliente obj, @PathParam("id") Long id);

    @DELETE
    @Path("/{id}")
    void delete( @PathParam("id") Long id );
}
