package com.qa.portal.common.security;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class QaSecurityContext {

    public String getUserName() {
        return null;
    }

    public List<String> getUserRoles() {
        return Collections.emptyList();
    }
}
