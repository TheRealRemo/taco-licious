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
        if (getSize().equalsIgnoreCase("single taco")) {
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

    public double calculateBasePrice() {
        double price = 0.00;
        if (getSize().equalsIgnoreCase("single taco")) {
            price = 3.50;
        } else if (getSize().equalsIgnoreCase("3-taco")) {
            price = 9.00;
        } else if (getSize().equalsIgnoreCase("burrito")) {
            price = 8.50;
        }
        return price;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append(shell)
                .append(" ")
                .append(size)
                .append("\n");

        stringBuilder.append("Base Price: $")
                .append(String.format("%.2f",calculateBasePrice()))
                .append("\n");

        stringBuilder.append("Toppings:\n");
/*
  Loops through each topping and prints it line-by-line.
  Premium toppings display their additional cost,
  while free regular toppings display only their name.
 */
        for (Topping topping : toppings) {
            double price = topping.getPrice(getSize());
            stringBuilder.append("- ")
                    .append(topping);

            if (price > 0) {
                stringBuilder.append(" $")
                        .append(String.format("%.2f", price));
            }

            stringBuilder.append("\n");
        }

        if (isCoveredInSalsaAndQueso) {
            stringBuilder.append("- Covered In Salsa And Queso")
                    .append("\n");
        }

        stringBuilder.append("Total Price: $")
                .append(String.format("%.2f", calculatePrice()));

        return stringBuilder.toString();
    }
}
