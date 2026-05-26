package com.pluralsight.tacoshop.model;

public class Sauce extends Topping{
    public Sauce(String name) {
        super(name);
    }

    @Override
    double getPrice(String size) {
        return 0;
    }
}
