package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.model.interfaces.IPriceable;

import java.util.ArrayList;

public class Taco implements IPriceable {
    private String size;
    private String shell;
    private ArrayList<Topping> toppings;
    private boolean isCoveredInSalsaAndQueso;

    //Empty parameters because we do not know what Taco modifications will be until populated
    public Taco() {
        this.toppings = new ArrayList<>();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public boolean isCoveredInSalsaAndQueso() {
        return isCoveredInSalsaAndQueso;
    }

    public void setCoveredInSalsaAndQueso(boolean coveredInSalsaAndQueso) {
        isCoveredInSalsaAndQueso = coveredInSalsaAndQueso;
    }

    @Override
    public double calculatePrice() {
        double price = 0.00;
        if (getSize().equalsIgnoreCase("single")) {
            price = 3.50;
        } else if (getSize().equalsIgnoreCase("3-taco")) {
            price = 9.00;
        } else if (getSize().equalsIgnoreCase("burrito")) {
            price = 8.50;
        }
        double toppingPrice = 0.00;
        for (Topping topping : toppings) {
            toppingPrice += topping.getPrice(getSize());
        }
        return price + toppingPrice;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Taco{" +
                "size='" + size + '\'' +
                ", shell='" + shell + '\'' +
                ", toppings=" + toppings +
                ", isCoveredInSalsaAndQueso=" + isCoveredInSalsaAndQueso +
                '}';
    }
}
