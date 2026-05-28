package com.pluralsight.tacoshop.model;

public abstract class PremiumTopping extends Topping {
    private boolean isExtra;

    public PremiumTopping(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public abstract double getPrice(String size);


}
