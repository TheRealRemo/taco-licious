package com.pluralsight.tacoshop.model;

public class Side extends Topping {
    public Side(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }


}
