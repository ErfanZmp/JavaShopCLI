package com.cein.erf;

public class Order {


    private static int ID = 1;
    private final int orderID;
    private final Product[] products;
    private final Customer customer;
    private final Payment payment;

    public Order(Customer customer, Product[] products, Payment payment) {
        this.orderID = ID++;
        this.customer = customer;
        this.products = products;
        this.payment = payment;

    }

    public int getOrderID() {
        return orderID;
    }

    public void print() {
        System.out.printf("ID: %d\n", orderID);
        System.out.printf("By: %s\n", customer);
        System.out.println("Products:");
        for (Product product: products) {
            System.out.println(product);
        }
        System.out.println(payment.getInfo());
    }
}
