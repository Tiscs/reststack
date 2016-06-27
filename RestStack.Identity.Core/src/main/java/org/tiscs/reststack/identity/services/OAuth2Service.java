package org.tiscs.reststack.identity.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * OAuth 2.0授权服务接口。
 */
@RequestMapping(value = "oauth2")
public interface OAuth2Service {
    /**
     * 获取授权码。
     *
     * @param responseType 响应类型。
     * @param clientId     客户端唯一编号。
     * @param redirect_uri 授权完成后的重定向页面地址。
     * @param scope        授权范围。
     * @param state        状态码，随重定向页面原样返回。
     */
    @RequestMapping(value = "/authorize", method = RequestMethod.GET)
    void getAuthorizeCode(@RequestParam(value = "response_type") String responseType, // code
                          @RequestParam(value = "client_id") String clientId,
                          @RequestParam(value = "redirect_uri", required = false) String redirect_uri,
                          @RequestParam(value = "scope", required = false) String scope,
                          @RequestParam(value = "state") String state);

    /**
     * 创建授权票据。
     *
     * @param grantType    授权类型。
     * @param clientId     客户端标识。
     * @param redirect_uri 重定向地址。
     * @param code         授权码。
     * @param refreshToken 刷新票据。
     * @return 授权票据数据。
     */
    @RequestMapping(value = "/access_token", method = RequestMethod.POST)
    Map<String, String> createAccessToken(@RequestParam(value = "grant_type") String grantType, // authorization_code
                                          @RequestParam(value = "client_id") String clientId,
                                          @RequestParam(value = "redirect_uri") String redirect_uri,
                                          @RequestParam(value = "code") String code,
                                          @RequestParam(value = "refresh_token") String refreshToken);
}
