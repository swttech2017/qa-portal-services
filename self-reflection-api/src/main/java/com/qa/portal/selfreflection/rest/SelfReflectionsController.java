package com.qa.portal.selfreflection.rest;

import com.qa.portal.common.security.QaSecurityContext;
import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import com.qa.portal.selfreflection.service.SelfReflectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.qa.portal.selfreflection.SelfReflectionConstants.SELF_REFLECTIONS_API_URL;
import static com.qa.portal.selfreflection.SelfReflectionConstants.SELF_REFLECTION_API_URL;


@RestController
public class SelfReflectionsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelfReflectionsController.class);

    @Autowired
    private SelfReflectionService selfReflectionService;

    @Autowired
    private QaSecurityContext securityContext;

    @GetMapping(SELF_REFLECTIONS_API_URL)
    public ResponseEntity<List<SelfReflectionFormDto>> getApplicationsByDepartment() {
        return ResponseEntity.ok(selfReflectionService.getSelfReflections(securityContext.getUserName()));
    }

    @PostMapping(SELF_REFLECTION_API_URL)
    public ResponseEntity<SelfReflectionFormDto> createSelfReflectionForm(@RequestBody SelfReflectionFormDto selfReflectionFormDto) {
        LOGGER.info("Request is " + selfReflectionFormDto);
        return ResponseEntity.ok(selfReflectionService.createSelfReflection(selfReflectionFormDto, securityContext.getUserName()));
    }
}
