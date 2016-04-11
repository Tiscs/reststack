package org.tiscs.reststack.core.datamodels;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 接口方法文档描述信息。
 */
public class ActionDoc {
    private String name;
    private String description;
    private String owner;
    private String path;
    private RequestMethod method;
    private String action;
    private String[] permissions;
    private String result;
    private ParamDoc bodyParam;
    private Iterable<ParamDoc> pathParams;
    private Iterable<ParamDoc> queryParams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RequestMethod getMethod() {
        return method;
    }

    public void setMethod(RequestMethod method) {
        this.method = method;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ParamDoc getBodyParam() {
        return bodyParam;
    }

    public void setBodyParam(ParamDoc bodyParam) {
        this.bodyParam = bodyParam;
    }

    public Iterable<ParamDoc> getPathParams() {
        return pathParams;
    }

    public void setPathParams(Iterable<ParamDoc> pathParams) {
        this.pathParams = pathParams;
    }

    public Iterable<ParamDoc> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Iterable<ParamDoc> queryParams) {
        this.queryParams = queryParams;
    }
}
