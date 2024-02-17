package org.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author HungDV
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity serverHttpSecurity){
        serverHttpSecurity
               .csrf(ServerHttpSecurity.CsrfSpec::disable)
               .authorizeExchange(authorize ->
                       authorize.pathMatchers("/eureka/**")
                               .permitAll()
                               .anyExchange()
                               .authenticated()
               )
               .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)

       ;

        return serverHttpSecurity.build();
    }
}
