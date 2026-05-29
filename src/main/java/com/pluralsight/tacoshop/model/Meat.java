package com.pluralsight.tacoshop.model;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(String size) {
        double price = 0.00;
        if (size.equalsIgnoreCase("single taco")) {
            price = 1.00;
        } else if (size.equalsIgnoreCase("3-taco")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("burrito")) {
            price = 3.00;
        }
        double extraPrice = 0.00;
        if (size.equalsIgnoreCase("single taco") && isExtra()) {
            extraPrice = 0.50;
        } else if (size.equalsIgnoreCase("3-taco") && isExtra()) {
            extraPrice = 1.00;
        } else if (size.equalsIgnoreCase("burrito") && isExtra()) {
            extraPrice = 1.50;
        }
        return price + extraPrice;
    }

    @Override
    public String toString() {
        String extra;
        if (isExtra()) {
            extra = " (Extra)";
        } else {
            extra = "";
        }
        return getName() + extra;
    }
}
