package org.tiscs.reststack.identity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tiscs.reststack.identity.models.mappers.OAuth2AgentMapper;
import org.tiscs.reststack.identity.services.OAuth2Service;

import java.util.Map;

@RestController
public class OAuth2Controller implements OAuth2Service {
    @Autowired
    private OAuth2AgentMapper oAuth2AgentMapper;

    @Override
    public void getAuthorizeCode(@RequestParam(value = "response_type") String responseType, @RequestParam(value = "client_id") String clientId, @RequestParam(value = "redirect_uri", required = false) String redirect_uri, @RequestParam(value = "scope", required = false) String scope, @RequestParam(value = "state") String state) {
    }

    @Override
    public Map<String, String> createAccessToken(@RequestParam(value = "grant_type") String grantType, @RequestParam(value = "client_id") String clientId, @RequestParam(value = "redirect_uri") String redirect_uri, @RequestParam(value = "code") String code, @RequestParam(value = "refresh_token") String refreshToken) {
        return null;
    }
}
