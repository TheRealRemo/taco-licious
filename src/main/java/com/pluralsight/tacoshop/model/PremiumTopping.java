package com.pluralsight.tacoshop.model;

public class PremiumTopping extends Topping {
    private boolean isExtra;

    public PremiumTopping(String name, boolean isExtra) {
        super(name);
        this.isExtra = isExtra;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    double getPrice(String size) {
        return 0;
    }


}
