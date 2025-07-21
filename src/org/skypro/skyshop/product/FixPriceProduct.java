package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private String name;
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getCost() {
        return FIXED_PRICE;
    }

    public String toString() {
        return this.getName() + ": " + this.getCost();
    }
}
