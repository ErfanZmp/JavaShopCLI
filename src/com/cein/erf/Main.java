package com.cein.erf;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Cart> carts = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Cart currentCart;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Welcome to our Shop!");

        while (true) {

            System.out.println("Please Enter your command: ");
            String[] tokens = scanner.nextLine().split(" ");

            if (tokens[0].equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                return;
            }

            switch (tokens[0].toLowerCase()) {
                case "product":
                    switch (tokens[1].toLowerCase()) {
                        case "add" -> addProduct();
                        case "remove" -> removeProduct(Integer.parseInt(tokens[2]));
                        case "browse" -> browse();
                        default -> System.out.println("Invalid Tokens.");
                    }
                    break;
                case "cart":
                    switch (tokens[1].toLowerCase()) {
                        case "add" -> addToCart(Integer.parseInt(tokens[2]));
                        case "remove" -> removeFromCart(Integer.parseInt(tokens[2]));
                        case "view" -> viewCard(Integer.parseInt(tokens[2]));
                        case "current" -> currentCart.print();
                        default -> System.out.println("Invalid Tokens.");
                    }
                    break;
                default:
                    System.out.println("Command Not Found!");

            }

        }
    }

    private static void viewCard(int id) {
        Cart cart = findCart(id);
        if (cart == null) {
            System.out.println("Cart not found!");
            return;
        }
        cart.print();
    }

    private static Customer findCustomer(int id) {
        for (Customer customer: customers) {
            if (customer.getCustomerID() == id) {
                return customer;
            }
        }
        return null;
    }

    private static Cart findCart(int id) {
        for (Cart cart : carts) {
            if (cart.getCartID() == id)
                return cart;
        }
        return null;
    }

    private static Product findProduct(int id) {
        for (Product product: products) {
            if (product.getProductID() == id)
                return product;
        }
        return null;
    }

    private static Order findOrder(int id) {
        for (Order order: orders) {
            if (order.getOrderID() == id)
                return order;
        }
        return null;
    }

    private static void addToCart(int productID) {
        if (currentCart == null) {
            System.out.println("No available cart found. Enter your CustomerID to create a new Cart: ");
            int id = Integer.parseInt(scanner.nextLine());
            Customer customer = findCustomer(id);
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }
            currentCart = new Cart(customer);
        }
        Product chosen = findProduct(productID);
        if (chosen == null) {
            System.out.println("Product not found!");
            return;
        }
        currentCart.addProduct(chosen);
        System.out.printf("%s added to cart successfully.\n", chosen);
    }

    private static void removeFromCart(int id) {
        Product removed =  currentCart.removeProduct(id);
        if (removed == null) {
            System.out.println("Product was not found in cart.");
            return;
        }
        System.out.printf("%s was removed from cart.", removed);
    }

    private static void browse() {
        if (products.size() == 0) {
            System.out.println("No product found.");
        }
        for (Product product: products) {
            System.out.println(product);
        }
    }

    private static void addProduct() {
        Product newProd;

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Price: ");
        Double price = Double.parseDouble(scanner.nextLine().trim());
        System.out.print("File Type: ");
        String type = scanner.nextLine().trim();
        System.out.print("URL: ");
        String url = scanner.nextLine().trim();

        if (type.equals("-") || url.equals("-")) {
            newProd = new Product(name, description, price);
        } else {
            newProd = new DigitalProduct(name, description, price, type, url);
        }
        products.add(newProd);
        System.out.println(newProd + " added.");
    }

    private static void removeProduct(int ID) {
        Product product = findProduct(ID);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        products.remove(product);
        System.out.printf("%s was removed successfully.\n", product);
    }
}
