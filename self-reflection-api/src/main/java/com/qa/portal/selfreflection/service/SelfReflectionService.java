package com.qa.portal.selfreflection.service;

import com.qa.portal.selfreflection.dto.SelfReflectionFormDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class SelfReflectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SelfReflectionService.class);

    @Autowired
    private RetrieveSelfReflectionsOperation retrieveSelfReflectionsOperation;

    @Autowired
    private CreateSelfReflectionOperation createSelfReflectionOperation;


    @Transactional
    public List<SelfReflectionFormDto> getSelfReflections(String userName) {
        List<SelfReflectionFormDto> selfReflections = retrieveSelfReflectionsOperation.getSelfReflections(userName);
        selfReflections.sort(Comparator.comparingLong((SelfReflectionFormDto srf) ->
                srf.getWeekCommencing().toEpochDay()).reversed());
        return selfReflections;
    }

    @Transactional
    public SelfReflectionFormDto createSelfReflection(SelfReflectionFormDto selfReflectionFormDto, String userName) {
        return createSelfReflectionOperation.createSelfReflection(selfReflectionFormDto, userName);
    }
}
