package com.model.model;

public class Team extends Identifiable<Long> {
    private final String name;

    {
        setID(0L);
    }

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
