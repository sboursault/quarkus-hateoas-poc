package com.sb.hateoas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.units.qual.K;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyMap;
import static org.apache.commons.lang3.ObjectUtils.firstNonNull;

public class LinksDto implements Map<String, LinkDto> {

    private final Map<String, LinkDto> innerMap;

    public LinksDto(Map<String, LinkDto> values) {
        innerMap = Map.copyOf(
                firstNonNull(values, emptyMap())
        );
    }

    @Override
    public int size() {
        return innerMap.size();
    }

    @Override
    public boolean isEmpty() {
        return innerMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return innerMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return innerMap.containsValue(value);
    }

    @Override
    public LinkDto get(Object key) {
        return innerMap.get(key);
    }

    @Override
    public LinkDto put(String key, LinkDto value) {
        return innerMap.put(key, value);
    }

    @Override
    public LinkDto remove(Object key) {
        return innerMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends LinkDto> m) {
        innerMap.putAll(m);
    }

    @Override
    public void clear() {
        innerMap.clear();
    }

    @Override
    public Set<String> keySet() {
        return innerMap.keySet();
    }

    @Override
    public Collection<LinkDto> values() {
        return innerMap.values();
    }

    @Override
    public Set<Entry<String, LinkDto>> entrySet() {
        return innerMap.entrySet();
    }
}