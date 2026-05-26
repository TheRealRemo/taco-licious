package com.pluralsight.tacoshop.model;

public abstract class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    abstract double getPrice(String size);
}
