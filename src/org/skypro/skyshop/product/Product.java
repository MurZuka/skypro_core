package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public Product(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Некорректное имя продукта");
        }
    }

    public String getName() {
        return this.name;
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
