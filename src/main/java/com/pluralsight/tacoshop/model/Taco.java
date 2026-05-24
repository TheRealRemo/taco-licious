package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.utils.IPriceable;

import java.util.ArrayList;

public class Taco implements IPriceable {
    private String size;
    private String shell;
    private ArrayList<Topping> toppings;
    private boolean isCoveredInSalsaAndQueso;

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
    public double getPrice() {
        return 0;
    }
}
