package com.pluralsight.tacoshop.model;

public class RegularTopping extends Topping {


    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public  double getPrice(String size){
        return 0.00;
    }

}
