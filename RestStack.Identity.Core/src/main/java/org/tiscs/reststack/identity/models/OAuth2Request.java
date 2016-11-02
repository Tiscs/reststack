package org.tiscs.reststack.identity.models;

import org.joda.time.DateTime;

import java.util.UUID;

/**
 * OAuth 2.0授权请求信息。
 */
public class OAuth2Request {
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
     * 有效期限。单位：秒。
     */
    private Long expiresIn;

    /**
     * 重定向地址。
     */
    private String redirectUri;

    /**
     * 授权范围。
     */
    private String scope;

    /**
     * 授权码。
     */
    private String code;

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

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
