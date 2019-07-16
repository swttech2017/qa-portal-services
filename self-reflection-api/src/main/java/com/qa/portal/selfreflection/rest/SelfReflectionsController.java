package com.qa.portal.selfreflection.rest;

import com.qa.portal.common.security.QaSecurityContext;
import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.service.SelfReflectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.qa.portal.selfreflection.SelfReflectionConstants.SELF_REFLECTIONS_API_URL;


@RestController
@RequestMapping(value = SELF_REFLECTIONS_API_URL)
public class SelfReflectionsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelfReflectionsController.class);

    @Autowired
    private SelfReflectionService selfReflectionService;

    @Autowired
    private QaSecurityContext securityContext;

    @GetMapping()
    public ResponseEntity<List<SelfReflectionFormDto>> getApplicationsByDepartment() {
        securityContext.getRoles().forEach(r -> LOGGER.info(r));
        LOGGER.info("User name is " + securityContext.getUserName());
        return ResponseEntity.ok(selfReflectionService.getSelfReflections(securityContext.getUserName()));
    }

 }
