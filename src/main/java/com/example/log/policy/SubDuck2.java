package com.example.log.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class SubDuck2 implements SuperDuck{

    @Autowired
    Entity2 entity2;

    List<Entity2> eList = new LinkedList<>();

    @Override
    public String getTag() {
        return "duck2";
    }

    @Override
    public void addList(String id, String name) {
        entity2.setId(id);
        entity2.setName(name);
        eList.add(entity2);
    }

    @Override
    public void executor() {
        System.out.println("eListSize: " + eList.size());
        eList.clear();
    }

    public List<Entity2> geteList() {
        return eList;
    }

    public void seteList(List<Entity2> eList) {
        this.eList = eList;
    }
}
