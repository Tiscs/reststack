package org.tiscs.reststack.identity.models;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * OAuth 2.0用户代理信息。
 */
public class OAuth2Agent {
    /**
     * OAuth 2.0客户端信息主键。
     */
    private UUID clientId;

    /**
     * 用户信息主键。
     */
    private UUID userId;

    /**
     * 创建时间。
     */
    private DateTime createTime;

    /**
     * 最后修改时间。
     */
    private DateTime lastModified;

    /**
     * 有效期限。单位：秒。
     */
    private Long expiresIn;

    /**
     * 授权范围。
     */
    private String scope;

    /**
     * 授权票据。
     */
    private String accessToken;

    /**
     * 刷新票据。
     */
    private String refreshToken;

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
