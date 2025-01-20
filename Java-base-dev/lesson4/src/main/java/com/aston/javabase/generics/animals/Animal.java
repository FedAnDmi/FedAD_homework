package com.aston.javabase.generics.animals;

public abstract class Animal {

    private final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
