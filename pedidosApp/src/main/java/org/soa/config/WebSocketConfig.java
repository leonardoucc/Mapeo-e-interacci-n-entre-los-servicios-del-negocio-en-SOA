package org.soa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Registro de puntos finales de WebSocket
        registry.addEndpoint("/ws").withSockJS(); // Endpoint para la conexión WebSocket
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configuración del broker de mensajes
        config.enableSimpleBroker("/topic", "/queue"); // Canales para la mensajería
        config.setApplicationDestinationPrefixes("/app"); // Prefijo para los mensajes del cliente
    }
}
