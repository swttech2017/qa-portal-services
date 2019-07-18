package com.qa.portal.common.persistence.entity;

import org.hibernate.annotations.UpdateTimestamp;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.sql.Timestamp;

@MappedSuperclass
public class QaBaseEntity {

    @UpdateTimestamp
    @Column(name="last_updated_timestamp")
    protected Timestamp lastUpdatedTimestamp;

    @Column(name="last_updated_by")
    protected String lastUpdatedBy;

    public Timestamp getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(Timestamp lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    @PrePersist
    void setLastUpdatedBy() {
        if (lastUpdatedBy == null) {
            lastUpdatedBy = getCurrentUserName();
        }
    }

    private String getCurrentUserName() {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        KeycloakSecurityContext keycloakContext = token.getAccount().getKeycloakSecurityContext();
        return keycloakContext.getToken().getPreferredUsername();
    }
}
