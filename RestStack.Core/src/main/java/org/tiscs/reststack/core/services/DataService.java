package org.tiscs.reststack.core.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tiscs.reststack.core.annotations.RequestQuery;
import org.tiscs.reststack.core.generic.DataQuery;

import java.util.List;

public interface DataService<E, K> {
    @RequestMapping(value = "/$count", method = RequestMethod.GET)
    long count(@RequestQuery DataQuery query);

    @RequestMapping(value = "", method = RequestMethod.GET)
    List<E> find(@RequestQuery DataQuery query);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    E findOne(@PathVariable K id);

    @RequestMapping(value = "", method = RequestMethod.POST)
    E create(@RequestBody E member);

    @RequestMapping(value = "", method = RequestMethod.PUT)
    int update(@RequestBody E member);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    int delete(@PathVariable K id);
}
