package com.pluralsight.tacoshop.model;

public abstract class RegularTopping extends Topping {


    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public abstract double getPrice(String size);

}
