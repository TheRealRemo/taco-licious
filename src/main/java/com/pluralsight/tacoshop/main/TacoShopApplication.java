package com.pluralsight.tacoshop.main;

import com.pluralsight.tacoshop.model.ChipsAndSalsa;
import com.pluralsight.tacoshop.model.Drink;
import com.pluralsight.tacoshop.model.Order;
import com.pluralsight.tacoshop.service.ReceiptFileManager;
import com.pluralsight.tacoshop.ui.UserInterface;

public class TacoShopApplication {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.display();


    }
}
