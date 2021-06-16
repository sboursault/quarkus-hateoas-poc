package com.sb.hateoas;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/gateway")
public class PizzaGatewayResource   {

    @Inject
    @RestClient
    PizzasService pizzasService;

    @GET
    @Path("/pizzas")
    public List<PizzaDto> list() {
        return pizzasService.list();
    }
}
