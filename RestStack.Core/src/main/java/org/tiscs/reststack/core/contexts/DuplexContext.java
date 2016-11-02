package org.tiscs.reststack.core.contexts;

import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.tiscs.reststack.core.handlers.PingWebSocketHandler;

@EnableWebSocket
public class DuplexContext implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new PingWebSocketHandler(), "/duplex").setAllowedOrigins("*");
    }
}
