package com.pluralsight.tacoshop.model;

public class PremiumTopping extends Topping {
    private boolean isExtra;

    public PremiumTopping(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }

    @Override
    double getPrice(String size) {
        return 0;
    }

    @Override
    public String toString() {
        return "PremiumTopping{" +
                "isExtra=" + isExtra +
                '}';
    }
}
