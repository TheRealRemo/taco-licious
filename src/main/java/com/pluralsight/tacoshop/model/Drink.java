package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.utils.IPriceable;

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
        return 0;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "flavor='" + flavor + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
