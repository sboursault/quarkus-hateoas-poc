package com.sb.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.firstNonNull;

public class LinkDto {

    private final String href;

    @JsonCreator
    public LinkDto(
            @JsonProperty("href") String href) {
        this.href = firstNonNull(href, "");
    }

    public String getHref() {
        return href;
    }
}