package org.tiscs.reststack.core.datamappers;

import org.tiscs.reststack.core.generic.DataQuery;

import java.util.List;

public interface DataMapper<E, K> {
    long count(DataQuery query);

    List<E> find(DataQuery query);

    E findOne(K id);

    int create(E model);

    int update(E model);

    int delete(K id);
}
