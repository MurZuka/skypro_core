package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName() + ": " + getCost();
    }

    public abstract int getCost();
    public abstract boolean isSpecial();
}
