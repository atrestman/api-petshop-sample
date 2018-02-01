package com.trestman.websocketpi.petshop.config;

import com.trestman.websocketpi.petshop.controller.ChatEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class EndpointConfig {

    @Bean
    public ChatEndpoint echoEndpoint() {
        return new ChatEndpoint();
    }

    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    }
}
