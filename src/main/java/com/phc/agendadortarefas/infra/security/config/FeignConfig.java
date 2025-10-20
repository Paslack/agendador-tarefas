package com.phc.agendadortarefas.infra.security.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Pega os dados da requisição HTTP atual
            ServletRequestAttributes attributes =
                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (attributes != null) {
                // Extrai o token do header Authorization
                String token = attributes.getRequest().getHeader("Authorization");

                // Se existe token, adiciona na chamada Feign
                if (token != null && !token.isEmpty()) {
                    requestTemplate.header("Authorization", token);
                }
            }
        };
    }
}