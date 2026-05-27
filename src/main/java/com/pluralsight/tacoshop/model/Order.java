package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.utils.IPriceable;

import java.util.ArrayList;
import java.util.List;

public class Order implements IPriceable {
    private ArrayList<IPriceable> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(IPriceable priceable) {
        items.add(priceable);
    }

    public ArrayList<IPriceable> getItems() {
        return items;
    }
    @Override
    public double calculatePrice() {
        double totalPrice = 0.00;
        for (IPriceable item : items) {
            totalPrice += item.calculatePrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                '}';
    }
}
