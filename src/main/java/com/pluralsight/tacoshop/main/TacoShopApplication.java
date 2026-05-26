package com.pluralsight.tacoshop.main;

import com.pluralsight.tacoshop.model.ChipsAndSalsa;

public class TacoShopApplication {
    public static void main(String[] args) {
        ChipsAndSalsa chips = new ChipsAndSalsa("Pico");
        System.out.println(chips);
    }
}
