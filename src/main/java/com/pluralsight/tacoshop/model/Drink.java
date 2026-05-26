package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.utils.IPriceable;

public class Drink implements IPriceable {

    @Override
    public double calculatePrice() {
        return 0;
    }
}
