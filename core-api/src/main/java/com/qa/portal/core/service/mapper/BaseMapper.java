package com.qa.portal.core.service.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//TODO - This is to be moved to the api-common project

@Component
public class BaseMapper {

    @Autowired
    private DozerBeanMapper mapper;


    public <S, T> T mapObject(S object, Class<T> clazz) {
        return mapper.map(object, clazz);
    }
}
