package com.sb.hateoas;

import com.fasterxml.jackson.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static org.apache.commons.lang3.ObjectUtils.firstNonNull;

public class PizzaDto {

    private final String name;              
    private final List<String> ingredients;
    private final LinksDto links;

    @JsonCreator
    public PizzaDto(
            @JsonProperty("name") String name,
            @JsonProperty("ingredients") List<String> ingredients,
            @JsonProperty("_links") Map<String, LinkDto> links) { // TODO change to LinksDto
        this.name = firstNonNull(name, "");
        this.ingredients = List.copyOf(
                firstNonNull(ingredients, emptyList())
        );
        this.links = new LinksDto(links);
    }
    public String getName() {
        return name;
    }
    
    public List<String> getIngredients() {
        return ingredients;
    }

    public LinksDto getLinks() {
        return links;
    }

}