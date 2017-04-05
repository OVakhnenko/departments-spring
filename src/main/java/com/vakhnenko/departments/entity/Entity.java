package com.vakhnenko.departments.entity;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class Entity {

    @NotEmpty
    private String name;
    private int ID;

    public Entity() {
    }

    public Entity(String name) {
        this.name = name;
        this.ID = getUniqeID();
    }

    public int getUniqeID() {
        return 0;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
