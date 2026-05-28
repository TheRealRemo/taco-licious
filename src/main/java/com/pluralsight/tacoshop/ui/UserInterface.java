package com.pluralsight.tacoshop.ui;

import com.pluralsight.tacoshop.model.Order;
import com.pluralsight.tacoshop.service.ReceiptFileManager;
import com.pluralsight.tacoshop.utils.IPriceable;

import java.util.Scanner;

public class UserInterface {
    private Order order;
    private Scanner scanner = new Scanner(System.in);

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
                order = new Order();
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
        boolean isOrdering = true;
       while (isOrdering){
           displayOrder();

        System.out.println("\n" + "Order Menu");
        System.out.println("--------------------------");
        System.out.println("1) Add Taco");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips And Salsa");
        System.out.println("4) Add Side");
        System.out.println("5) Checkout");
        System.out.println("0) Cancel Order");
        String input = scanner.nextLine();


       }
    }


    //helper methods

    /// for printing out order items
    public void displayOrder() {
        System.out.println("--- Your Order ---");
        if (order.getItems().isEmpty()) {
            System.out.println("Empty");
        } else {
            for (IPriceable priceable : order.getItems()) {
                System.out.println(priceable);
            }
        }
    }
}
