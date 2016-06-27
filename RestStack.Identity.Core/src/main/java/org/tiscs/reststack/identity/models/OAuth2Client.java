package org.tiscs.reststack.identity.models;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * OAuth 2.0客户端信息。
 */
public class OAuth2Client {
    /**
     * 主键。
     */
    private UUID id;

    /**
     * 创建时间。
     */
    private DateTime createTime;

    /**
     * 最后修改时间。
     */
    private DateTime lastModified;

    /**
     * 是否已经禁用。
     */
    private Boolean disabled;

    /**
     * 名称。
     */
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public DateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
