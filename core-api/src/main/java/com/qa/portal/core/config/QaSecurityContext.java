package com.qa.portal.core.config;

import com.qa.portal.core.persistence.entity.RoleEntity;
import com.qa.portal.core.persistence.repository.RoleRepository;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;

//TODO - This is to be moved to the api-common project

@Component
public class QaSecurityContext {

    private final Logger LOGGER = LoggerFactory.getLogger(QaSecurityContext.class);

    @Autowired
    private RoleRepository roleRepository;

    private List<RoleEntity> roles;

    public String getName() {
        return getAccessToken().getName();
    }

    public Set<String> getRoles() {
        return getAccessToken().getRealmAccess().getRoles();
    }

    public String getFirstName() {
        return getAccessToken().getGivenName();
    }

    public String getSurname() {
        return getAccessToken().getFamilyName();
    }

    private AccessToken getAccessToken() {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        KeycloakSecurityContext keycloakContext = token.getAccount().getKeycloakSecurityContext();
        return keycloakContext.getToken();
    }

    @PostConstruct
    public void init() {
        roles = roleRepository.findAll();
    }
}
