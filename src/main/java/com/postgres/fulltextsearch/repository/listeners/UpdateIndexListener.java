package com.postgres.fulltextsearch.repository.listeners;

import com.postgres.fulltextsearch.service.FtsGlobalService;
import com.postgres.fulltextsearch.utils.BeanUtils;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import java.util.UUID;

@Component
public class UpdateIndexListener {

    @PostPersist
    public void uploadPostPersist(Object object){
        BeanUtils.getBean(FtsGlobalService.class).saveNewToken(PropertyAccessorFactory.forBeanPropertyAccess(object).getPropertyValue("description").toString(),
                PropertyAccessorFactory.forBeanPropertyAccess(object).getPropertyValue("name").toString(),
                (UUID) PropertyAccessorFactory.forBeanPropertyAccess(object).getPropertyValue("id"));
    }
}