package com.pluralsight.tacoshop.model;

import com.pluralsight.tacoshop.model.interfaces.IPriceable;

import java.util.ArrayList;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (IPriceable item : items) {
            stringBuilder.append(item)
                    .append("\n");

        }
        stringBuilder.append("\n")
                .append("Grand Total: $")
                .append(String.format("%.2f", calculatePrice()));

        return stringBuilder.toString();

    }
}
