package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
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

    @Override
    public String getSearchTerm() {
        return this.getName();
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getCost();
    public abstract boolean isSpecial();
}
