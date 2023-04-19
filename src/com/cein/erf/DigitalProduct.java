package com.cein.erf;

public class DigitalProduct extends Product {

    private final String type;
    private final String url;

    public DigitalProduct(String name, String description, Double price, String type, String url) {
        super(name, description, price);
        this.type = type;
        this.url = url;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFile Type: " + type + "\nURL: " + url;
    }
}
