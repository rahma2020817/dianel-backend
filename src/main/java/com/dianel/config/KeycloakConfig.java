package com.dianel.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KeycloakConfig {

//    @Value("${keycloak.realm}")
//    private String REALM;
//
//    @Value("${jwt.auth.converter.resource-id}")
//    private String CLIENT_ID;
//
//    @Value("${client.secret}")
//    private String CLIENT_SECRET;
//
//    @Value("${admin.keycloak.url}")
//    private String SERVER_URL;
//
//    @Value("${kc.admin.username}")
//    private String ADMIN_USERNAME;
//
//    @Value("${kc.admin.password}")
//    private String ADMIN_PASSWORD;
//
//    @Bean
//    public Keycloak keycloak() {
//        return KeycloakBuilder.builder()
//                .serverUrl(SERVER_URL)
//                .realm(REALM)
//                .clientId(CLIENT_ID)
//                .clientSecret(CLIENT_SECRET)
//                .username(ADMIN_USERNAME)
//                .password(ADMIN_PASSWORD)
//                .grantType(OAuth2Constants.PASSWORD)
//                .build();
//    }
}
