package com.pluralsight.tacoshop.service;

import com.pluralsight.tacoshop.model.Order;
import com.pluralsight.tacoshop.utils.IPriceable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptFileManager {
    private LocalDateTime time = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
    private String fileName = time.format(dateTimeFormatter) + ".txt";

    public String getFileName() {
        return fileName;
    }

    public void saveReceipt(Order order) {


        try {
            File file = new File("receipts/" + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("receipts/" + fileName));

            for (IPriceable priceable : order.getItems()) {
                bw.write(priceable.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("File Error");
        }
    }


}
