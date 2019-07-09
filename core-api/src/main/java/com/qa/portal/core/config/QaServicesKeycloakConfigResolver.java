package com.qa.portal.core.config;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static com.qa.portal.core.CoreConstants.KEYCLOAK_CONFIG_FILE_PROP;

//TODO - This is to be moved to the api-common project

@Component
public class QaServicesKeycloakConfigResolver implements KeycloakConfigResolver {

    @Autowired
    private Environment env;

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
        return KeycloakDeploymentBuilder.build(getClass().getClassLoader().getResourceAsStream(env.getProperty(KEYCLOAK_CONFIG_FILE_PROP)));
    }
}
