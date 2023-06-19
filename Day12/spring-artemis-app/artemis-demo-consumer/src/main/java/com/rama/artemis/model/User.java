package com.rama.artemis.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    public User(){

    }
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

}
