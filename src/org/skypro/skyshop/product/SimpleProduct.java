package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private String name;
    private int cost;

    public SimpleProduct(String name, int cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
