package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class SimpleProduct extends Product implements Searchable {
    private int cost;

    public SimpleProduct(String name, int cost) {
        super(name);

        if (cost > 0) {
            this.cost = cost;
        }
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
