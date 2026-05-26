package com.pluralsight.tacoshop.model;

public class Cheese extends PremiumTopping{
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }


    @Override
    double getPrice(String size) {
        return super.getPrice(size);
    }

    @Override
    public String toString() {
        return "Cheese{}";
    }
}
