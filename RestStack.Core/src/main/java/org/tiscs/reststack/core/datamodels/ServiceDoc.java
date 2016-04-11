package org.tiscs.reststack.core.datamodels;

/**
 * 接口服务文档描述信息。
 */
public class ServiceDoc {
    private String name;
    private String description;
    private String controller;
    private Iterable<ActionDoc> actions;

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

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public Iterable<ActionDoc> getActions() {
        return actions;
    }

    public void setActions(Iterable<ActionDoc> actions) {
        this.actions = actions;
    }
}
