package com.sb.hateoas;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import java.util.List;
import java.util.Set;


@RegisterRestClient(configKey="pizza-api")
public interface PizzasService {

    @GET
    @Path("/pizzas")
    List<PizzaDto> list();

}
