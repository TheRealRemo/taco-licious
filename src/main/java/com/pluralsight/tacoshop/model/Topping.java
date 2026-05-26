package com.pluralsight.tacoshop.model;

public abstract class Topping {
    private String name;

    abstract double getPrice(String size);
}
