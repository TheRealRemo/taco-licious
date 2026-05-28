package com.pluralsight.tacoshop.ui;

import com.pluralsight.tacoshop.model.Order;
import com.pluralsight.tacoshop.model.Taco;
import com.pluralsight.tacoshop.model.interfaces.IPriceable;

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
        while (isOrdering) {
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

            switch (input) {
                case "1" -> displayAddTaco();
                case "2" -> displayAddDrink();
                case "3" -> displayAddChipsAndSalsa();
                case "4" -> displayAddSide();
                case "5" -> displayCheckout();
                case "0" -> isOrdering = false;
                default -> System.out.println("Invalid Input Please Try Again");
            }


        }
    }

    public void displayAddTaco() {
        Taco taco = new Taco();
        boolean validOption = false;

        while (!validOption) {

            System.out.println("Let's make a new Taco!");
            System.out.println("Would you like a Single Taco, 3-Taco, or Burrito?");
            System.out.print("Please choose one of the three options: ");

            String size = scanner.nextLine();

            if (size.equalsIgnoreCase("single")
                    || size.equalsIgnoreCase("3-taco")
                    || size.equalsIgnoreCase("burrito")) {

                taco.setSize(size);
                validOption = true;

            } else {
                System.out.println("We don't have that kind of taco, (for now) Please try again.");
            }
        }

        validOption = false;

        while (!validOption) {
            System.out.println("Great! What shell would you like?");
            System.out.println("Corn, Flour, Hard Shell or Bowl?");
            System.out.print("Please choose one of the four options: ");

            String shell = scanner.nextLine();

            if (shell.equalsIgnoreCase("corn")
                    || shell.equalsIgnoreCase("flour")
                    || shell.equalsIgnoreCase("hard shell")
                    || shell.equalsIgnoreCase("bowl")) {

                taco.setShell(shell);
                validOption = true;

            } else {
                System.out.println("Invalid shell option. Please try again.");
            }

        }
    }

    public void displayAddDrink() {

    }

    public void displayAddChipsAndSalsa() {

    }

    public void displayAddSide() {

    }

    public void displayCheckout() {

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
