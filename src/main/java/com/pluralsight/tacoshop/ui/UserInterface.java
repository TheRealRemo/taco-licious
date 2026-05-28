package com.pluralsight.tacoshop.ui;

import com.pluralsight.tacoshop.model.Meat;
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


            System.out.println("\n" + "Order Menu");
            System.out.println("--------------------------");
            displayOrder();
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
            System.out.println("What kind would you like?");
            System.out.println("1.) Single Taco ($3.50)");
            System.out.println("2.) 3-Taco ($9.00)");
            System.out.println("3.) Burrito? ($8.50)");
            System.out.print("Please enter one of the three options: ");

            String size = scanner.nextLine();

            switch (size) {
                case "1" -> {
                    taco.setSize("Single");
                    validOption = true;
                }
                case "2" -> {
                    taco.setSize("3-Taco");
                    validOption = true;
                }
                case "3" -> {
                    taco.setSize("Burrito");
                    validOption = true;
                }
                default -> System.out.println("We don't have that kind of taco, (for now..) Please try again.");
            }
        }
        displayShellChoice(taco);
        displayAddMeat(taco);

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

    public void displayAddMeat(Taco taco) {
        boolean addingMeats = true;

        while (addingMeats) {

            System.out.println("\nChoose a meat:");
            System.out.println("1) Carne Asada");
            System.out.println("2) Al Pastor");
            System.out.println("3) Carnitas");
            System.out.println("4) Pollo");
            System.out.println("5) Chorizo");
            System.out.println("6) Pescado");
            System.out.println("0) Done Adding Meats");
            System.out.print("Please enter option here: ");

            String meatChoice = scanner.nextLine();

            if (meatChoice.equals("0")) {
                addingMeats = false;
                continue;
            }

            String meatName;

            switch (meatChoice) {
                case "1" -> meatName = "Carne Asada";
                case "2" -> meatName = "Al Pastor";
                case "3" -> meatName = "Carnitas";
                case "4" -> meatName = "Pollo";
                case "5" -> meatName = "Chorizo";
                case "6" -> meatName = "Pescado";
                default -> {
                    System.out.println("Invalid meat option.");
                    continue;
                }
            }

            System.out.println("Would you like extra meat?");
            System.out.println("1) Yes");
            System.out.println("2) No");

            String extraChoice = scanner.nextLine();

            boolean isExtra = extraChoice.equals("1");

            Meat meat = new Meat(meatName, isExtra);

            taco.addTopping(meat);

            System.out.println(meatName + " added!");
        }
    }

    public void displayShellChoice(Taco taco) {
        boolean validOption = false;
        while (!validOption) {
            System.out.println("Great! What shell would you like?");
            System.out.println("1.) Corn");
            System.out.println("2.) Flour");
            System.out.println("3.) Hard Shell");
            System.out.println("4.) Bowl");
            System.out.print("Please choose one of the four options: ");

            String shell = scanner.nextLine();

            switch (shell) {
                case "1" -> {
                    taco.setShell("Corn");
                    validOption = true;
                }
                case "2" -> {
                    taco.setShell("Flour");
                    validOption = true;
                }
                case "3" -> {
                    taco.setShell("Hard Shell");
                    validOption = true;
                }
                case "4" -> {
                    taco.setShell("Bowl");
                    validOption = true;
                }
                default -> {
                    System.out.println("Sorry, please try choosing a valid shell option again.");
                }
            }

        }
    }
}
