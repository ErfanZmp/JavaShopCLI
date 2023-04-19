package com.cein.erf;

import java.util.Scanner;

public class Payment {

    private final Customer customer;
    private final double amount;
    private boolean paid;

    public Payment(Customer customer, double amount) {
        this.customer = customer;
        this.amount = amount;
        this.paid = false;
    }

     public void pay() {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter card number: ");
         String card = scanner.nextLine();
         System.out.println("Enter passcode: ");
         String pass = scanner.nextLine();
         paid = true;
     }

     public String getInfo() {
        if (paid) return String.format("$%f is paid by %s.", amount, customer);
         return String.format("$%f not paid.", amount);
     }
}
