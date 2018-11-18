package com.example.log.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class InitClass {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ServiceLocator serviceLocator;
    @PostConstruct
    public void init(){
        logger.info("........................... init ............................");
        Map<String,SuperDuck> map = serviceLocator.getMap();
        Map<String,SuperDuck> subMap = new HashMap<>();
        for(Map.Entry<String,SuperDuck> entry : map.entrySet()){
            SuperDuck superDuck = entry.getValue();
            subMap.put(superDuck.getTag(),superDuck);
        }
        for (Map.Entry<String,SuperDuck> entry : subMap.entrySet()){
            String key = entry.getKey();
            SuperDuck superDuck = entry.getValue();
            for (int i = 0; i < 10; i++) {
                superDuck.addList("id"+ i,"name" + i);
            }
            superDuck.executor();
            System.out.println(key);
        }
        System.out.println(".......................................");
        SuperDuck superD = subMap.get("duck2");

        for (int i = 0; i < 100; i++) {
            superD.addList("id" + i,"name" + i);
        }
        superD.executor();
        superD.executor();
    }
}
