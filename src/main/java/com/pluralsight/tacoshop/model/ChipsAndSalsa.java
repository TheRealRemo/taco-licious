package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.model.interfaces.IPriceable;

public class ChipsAndSalsa implements IPriceable {
    private String salsaType;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }


    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }

    @Override
    public double calculatePrice() {

        return 1.50;
    }

    @Override
    public String toString() {
        return String.format("Chips & Salsa w/" + salsaType + " $" + String.format("%.2f", calculatePrice()));
    }
}
