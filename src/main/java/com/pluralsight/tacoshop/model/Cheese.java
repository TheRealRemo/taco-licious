package com.pluralsight.tacoshop.model;

public class Cheese extends PremiumTopping {
    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }


    @Override
    public double getPrice(String size) {
        double price = 0.00;
        if (size.equalsIgnoreCase("single")) {
            price = 0.75;
        } else if (size.equalsIgnoreCase("3-taco")) {
            price = 1.50;
        } else if (size.equalsIgnoreCase("burrito")) {
            price = 2.25;
        }
        double extraPrice = 0.00;
        if (size.equalsIgnoreCase("single taco") && isExtra()) {
            extraPrice = 0.30;
        } else if (size.equalsIgnoreCase("3-taco") && isExtra()) {
            extraPrice = 0.60;
        } else if (size.equalsIgnoreCase("burrito") && isExtra()) {
            extraPrice = 0.90;
        }
        return price + extraPrice;
    }

    @Override
    public String toString() {
        String extra = "";
        if (isExtra()) {
            extra = "(Extra)";
        } else {
            extra = "";
        }
        return getName() + extra;
    }
}
