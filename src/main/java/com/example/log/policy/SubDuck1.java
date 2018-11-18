package com.example.log.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SubDuck1 implements SuperDuck {

    @Autowired
    Entity1 entity1;

    public List<Entity1> getyList() {
        return yList;
    }

    public void setyList(List<Entity1> yList) {
        this.yList = yList;
    }

    List<Entity1> yList = new LinkedList<>();

    @Override
    public String getTag() {
        return "duck1";
    }

    @Override
    public void addList(String id, String name) {
        entity1.setId(id);
        entity1.setName(name);
        yList.add(entity1);
    }

    @Override
    public void executor() {
        System.out.println("yListSize: " + yList.size());
        yList.clear();
    }
}
