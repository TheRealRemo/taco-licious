package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.model.interfaces.IPriceable;

public class Drink implements IPriceable {
    private String flavor;
    private String size;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double calculatePrice() {
        double price = 0.00;
        if (size.equalsIgnoreCase("small")) {
            price = 2.00;
        } else if (size.equalsIgnoreCase("medium")) {
            price = 2.50;
        } else if (size.equalsIgnoreCase("large")) {
            price = 3.00;
        }
        return price;
    }

    @Override
    public String toString() {
        return  size + " " + flavor + " " + "$" + String.format("%.2f", calculatePrice());
    }
}
