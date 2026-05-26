package com.pluralsight.tacoshop.model;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    double getPrice(String size) {
        return super.getPrice(size);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
