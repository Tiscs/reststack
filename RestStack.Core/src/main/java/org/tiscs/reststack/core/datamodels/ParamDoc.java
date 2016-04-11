package org.tiscs.reststack.core.datamodels;

/**
 * 接口方法参数文档描述信息。
 */
public class ParamDoc {
    private String name;
    private String description;
    private String paramName;
    private String paramType;
    private boolean required;

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

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
