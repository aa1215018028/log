package com.example.log.policy;

import org.springframework.stereotype.Component;

@Component
public interface SuperDuck {
    String getTag();
    void addList(String id, String name);
    void executor();
}
