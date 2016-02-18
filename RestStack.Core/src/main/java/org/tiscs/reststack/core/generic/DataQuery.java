package org.tiscs.reststack.core.generic;

import java.util.Map;

public class DataQuery {
    private DataFilter filter;
    private Map<String, SortOrder> orders;
    private Map<String, String> fields;
    private long skip;
    private long take;

    public DataFilter getFilter() {
        return filter;
    }

    public void setFilter(DataFilter filter) {
        this.filter = filter;
    }

    public Map<String, SortOrder> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, SortOrder> orders) {
        this.orders = orders;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public long getSkip() {
        return skip;
    }

    public void setSkip(long skip) {
        this.skip = skip;
    }

    public long getTake() {
        return take;
    }

    public void setTake(long take) {
        this.take = take;
    }
}
