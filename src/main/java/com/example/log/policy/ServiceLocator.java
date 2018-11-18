package com.example.log.policy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServiceLocator implements ApplicationContextAware {
    private Map<String,SuperDuck> duckMap;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        duckMap = applicationContext.getBeansOfType(SuperDuck.class);
    }
    public Map<String,SuperDuck> getMap(){
        return duckMap;
    }
}
