package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class DiscountedProduct extends Product implements Searchable {
    private int basePrice;
    private byte discountPercent;

    public DiscountedProduct(String name, int basePrice, byte discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public int getDiscountPercent() {
        return (int) this.discountPercent;
    }

    @Override
    public int getCost() {
        return basePrice - (basePrice * (discountPercent / 100));
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.getCost() + " (" + this.getDiscountPercent() + "%)";
    }
}
