package com.cein.erf;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private static int ID = 1;
    private final int cartID;
    private final List<Product> products;
    private Customer customer;

    public Cart(Customer customer) {
        this.cartID = ID++;
        this.customer = customer;
        products = new ArrayList<>();
    }

    public Product[] getProducts() {
        return products.toArray(new Product[0]);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product removeProduct(int prodID) {
        for (Product product: products) {
            if (product.getProductID() == prodID) {
                products.remove(product);
                return product;
            }
        }
        return null;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getPrice() {
        double sum = 0;
        for (Product prod: products) {
            sum += prod.getPrice();
        }
        return sum;
    }

    public int getCartID() {
        return cartID;
    }

    public void print() {
        System.out.printf("CartID: %d\nCustomerID: %d", cartID, customer.getCustomerID());
        System.out.println("Products:");
        for (Product product: products) {
            System.out.println(product);
        }
        System.out.println("Total Price: " + getPrice());
    }
}
