package com.pluralsight.tacoshop.ui;

import com.pluralsight.tacoshop.model.*;
import com.pluralsight.tacoshop.model.interfaces.IPriceable;
import com.pluralsight.tacoshop.service.ReceiptFileManager;

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
                System.out.println("\nThank you for coming!");
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
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("--------------------------");
            System.out.print("Please enter choice here: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> displayAddTaco();
                case "2" -> displayAddDrink();
                case "3" -> displayAddChipsAndSalsa();
                case "4" -> {
                    if (displayCheckout()) {
                        isOrdering = false;
                    }
                }
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
                    taco.setSize("Single Taco");
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
        displayAddCheese(taco);
        displayAddRegularToppings(taco);
        displayAddSauces(taco);
        displayCoverInSalsaAndQueso(taco);
        displayAddSide(taco);

        order.addItem(taco);

        System.out.println("\nTaco added to order! Yum! Anything else? Drink? Chips?");
    }


    public void displayAddDrink() {
        Drink drink = new Drink(null, null);
        boolean validOption = false;

        while (!validOption) {

            System.out.println("\nChoose a drink:");
            System.out.println("1) Orange Fanta");
            System.out.println("2) Coke");
            System.out.println("3) Sprite");
            System.out.println("4) Horchata");
            System.out.print("Please enter option here: ");

            String flavorChoice = scanner.nextLine();

            String flavor;

            switch (flavorChoice) {
                case "1" -> flavor = "Orange Fanta";
                case "2" -> flavor = "Coke";
                case "3" -> flavor = "Sprite";
                case "4" -> flavor = "Horchata";
                default -> {
                    System.out.println("Invalid drink option.");
                    continue;
                }
            }

            System.out.println("\nChoose a size:");
            System.out.println("1) Small ($2.00)");
            System.out.println("2) Medium ($2.50)");
            System.out.println("3) Large ($3.00)");
            System.out.print("Please enter option here: ");

            String sizeChoice = scanner.nextLine();

            String size;

            switch (sizeChoice) {
                case "1" -> size = "Small";
                case "2" -> size = "Medium";
                case "3" -> size = "Large";
                default -> {
                    System.out.println("Invalid size option.");
                    continue;
                }
            }

            drink = new Drink(flavor, size);
            validOption = true;
        }

        order.addItem(drink);

        System.out.println("\n" + drink + " added!");
    }

    public void displayAddChipsAndSalsa() {

        boolean validOption = false;

        while (!validOption) {

            System.out.println("\nChoose a salsa for your chips:");
            System.out.println("1) Salsa Verde");
            System.out.println("2) Salsa Roja");
            System.out.println("3) Pico De Gallo");
            System.out.print("Please enter option here: ");

            String salsaChoice = scanner.nextLine();

            String salsaType;

            switch (salsaChoice) {
                case "1" -> salsaType = "Salsa Verde";
                case "2" -> salsaType = "Salsa Roja";
                case "3" -> salsaType = "Pico De Gallo";
                default -> {
                    System.out.println("Invalid salsa option.");
                    continue;
                }
            }

            ChipsAndSalsa chipsAndSalsa = new ChipsAndSalsa(salsaType);

            order.addItem(chipsAndSalsa);

            System.out.println("\nChips and " + salsaType + " added!");
            validOption = true;
        }
    }



    public boolean displayCheckout() {

        System.out.println("\n========== CHECKOUT ==========");
        System.out.println(order);

        while (true) {

            System.out.println("\n1) Confirm Order");
            System.out.println("0) Cancel Order");
            System.out.print("Please enter choice here: ");

            String input = scanner.nextLine();

            switch (input) {

                case "1" -> {
                    ReceiptFileManager fileManager = new ReceiptFileManager();
                    fileManager.saveReceipt(order);

                    System.out.println("\nReceipt saved as: "
                            + fileManager.getFileName());
                    System.out.println("Enjoy your meal!");

                    return true;
                }

                case "0" -> {
                    System.out.println("\nOrder cancelled.");
                    return true;
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    //display helper methods

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
            System.out.print("Enter here: ");
            String extraChoice = scanner.nextLine();

            boolean isExtra = extraChoice.equals("1");

            Meat meat = new Meat(meatName, isExtra);

            taco.addTopping(meat);

            System.out.println(meatName + " added!");
        }
    }

    public void displayAddCheese(Taco taco) {
        boolean addingCheeses = true;

        while (addingCheeses) {

            System.out.println("\nChoose a cheese:");
            System.out.println("1) Queso Fresco");
            System.out.println("2) Oaxaca");
            System.out.println("3) Cotija");
            System.out.println("4) Cheddar");
            System.out.println("0) Done Adding Cheese");
            System.out.print("Please enter option here: ");

            String cheeseChoice = scanner.nextLine();

            if (cheeseChoice.equals("0")) {
                addingCheeses = false;
                continue;
            }

            String cheeseName;

            switch (cheeseChoice) {
                case "1" -> cheeseName = "Queso Fresco";
                case "2" -> cheeseName = "Oaxaca";
                case "3" -> cheeseName = "Cotija";
                case "4" -> cheeseName = "Cheddar";
                default -> {
                    System.out.println("Invalid cheese option.");
                    continue;
                }
            }

            System.out.println("Would you like extra cheese?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.print("Enter here: ");
            String extraChoice = scanner.nextLine();

            boolean isExtra = extraChoice.equals("1");

            Cheese cheese = new Cheese(cheeseName, isExtra);

            taco.addTopping(cheese);

            System.out.println(cheeseName + " added!");
        }
    }

    public void displayAddRegularToppings(Taco taco) {
        boolean addingToppings = true;

        while (addingToppings) {

            System.out.println("\nChoose a regular topping:");
            System.out.println("1) Lettuce");
            System.out.println("2) Cilantro");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapeños");
            System.out.println("6) Radishes");
            System.out.println("7) Pico De Gallo");
            System.out.println("8) Guacamole");
            System.out.println("9) Corn");
            System.out.println("0) Done Adding Toppings");

            String toppingChoice = scanner.nextLine();

            if (toppingChoice.equals("0")) {
                addingToppings = false;
                continue;
            }

            String toppingName;

            switch (toppingChoice) {
                case "1" -> toppingName = "Lettuce";
                case "2" -> toppingName = "Cilantro";
                case "3" -> toppingName = "Onions";
                case "4" -> toppingName = "Tomatoes";
                case "5" -> toppingName = "Jalapeños";
                case "6" -> toppingName = "Radishes";
                case "7" -> toppingName = "Pico De Gallo";
                case "8" -> toppingName = "Guacamole";
                case "9" -> toppingName = "Corn";
                default -> {
                    System.out.println("Invalid topping option.");
                    continue;
                }
            }

            RegularTopping topping = new RegularTopping(toppingName);

            taco.addTopping(topping);

            System.out.println(toppingName + " added!");
        }
    }

    public void displayAddSauces(Taco taco) {
        boolean addingSauces = true;

        while (addingSauces) {

            System.out.println("\nChoose a sauce:");
            System.out.println("1) Salsa Verde");
            System.out.println("2) Salsa Roja");
            System.out.println("3) Chipotle");
            System.out.println("4) Habanero");
            System.out.println("5) Mild");
            System.out.println("6) Extra Hot");
            System.out.println("0) Done Adding Sauces");
            System.out.print("Please enter option here: ");

            String sauceChoice = scanner.nextLine();

            if (sauceChoice.equals("0")) {
                addingSauces = false;
                continue;
            }

            String sauceName;

            switch (sauceChoice) {
                case "1" -> sauceName = "Salsa Verde";
                case "2" -> sauceName = "Salsa Roja";
                case "3" -> sauceName = "Chipotle";
                case "4" -> sauceName = "Habanero";
                case "5" -> sauceName = "Mild";
                case "6" -> sauceName = "Extra Hot";
                default -> {
                    System.out.println("Invalid sauce option.");
                    continue;
                }
            }

            Sauce sauce = new Sauce(sauceName);

            taco.addTopping(sauce);

            System.out.println(sauceName + " added!");
        }
    }

    public void displayCoverInSalsaAndQueso(Taco taco) {
        boolean validOption = false;

        while (!validOption) {

            System.out.println("\nWould you like your taco covered in salsa and queso?");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.print("Please enter option here: ");

            String coverChoice = scanner.nextLine();

            switch (coverChoice) {
                case "1" -> {
                    taco.setCoveredInSalsaAndQueso(true);
                    validOption = true;
                }
                case "2" -> {
                    taco.setCoveredInSalsaAndQueso(false);
                    validOption = true;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void displayAddSide(Taco taco) {

        boolean addingSides = true;

        while (addingSides) {

            System.out.println("\nChoose a side:");
            System.out.println("1) Crema");
            System.out.println("2) Lime Wedges");
            System.out.println("0) Done Adding Sides");
            System.out.print("Please enter option here: ");

            String sideChoice = scanner.nextLine();

            if (sideChoice.equals("0")) {
                addingSides = false;
                continue;
            }

            String sideName;

            switch (sideChoice) {
                case "1" -> sideName = "Crema";
                case "2" -> sideName = "Lime Wedges";
                default -> {
                    System.out.println("Invalid side option.");
                    continue;
                }
            }

            Side side = new Side(sideName);

            taco.addTopping(side);

            System.out.println(sideName + " added!");
        }
    }

}



