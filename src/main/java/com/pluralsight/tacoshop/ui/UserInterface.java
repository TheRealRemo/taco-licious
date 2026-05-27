package com.pluralsight.tacoshop.ui;

import com.pluralsight.tacoshop.model.Order;
import com.pluralsight.tacoshop.service.ReceiptFileManager;
import com.pluralsight.tacoshop.utils.IPriceable;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner = new Scanner(System.in);
    private ReceiptFileManager fileManager = new ReceiptFileManager();

    public void display() {

        boolean running = true;

        while (running) {
            System.out.println("\n");
            System.out.println("=========Welcome to Taco-Licious!=========");
            System.out.println("Would you like to start a new order?");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please enter here: ");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                displayNewOrder();
            } else if (input.equals("0")) {
                running = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
        scanner.close();
    }

    public void displayNewOrder() {
        displayOrder();

    }


    //helper methods

    /// solely for printing out order items
    public void displayOrder() {
        System.out.println("--- Your Order ---");
        for (IPriceable priceable : order.getItems()) {
            System.out.println(priceable);
        }
    }
}
