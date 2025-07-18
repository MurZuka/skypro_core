package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];

    public ProductBasket(Product[] products) {
        for (int i = 0; i < this.products.length; i++) {
            if (i < products.length) {
                this.products[i] = products[i];
            }
        }
    }

    public void addProduct(Product product) {
        boolean added = false;

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                added = true;
                break;
            }
        }

        if (!(added)) {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int result = 0;

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                result += products[i].getCost();
            }
        }

        return result;
    }

    public String toString() {
        String result = "";

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                result = result + products[i].getName() + ": " + products[i].getCost() + "\n";
            }
        }

        if (result.isBlank()) {
            result = "в корзине пусто";
        } else {
            result = result + "Итого: " + getTotalCost();
        }

        return result;
    }

    public boolean isProductInBasket(String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                if (products[i].getName().equals(productName)) {
                    return true;
                }
            }
        }

        return false;
    }

    public void purgeBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
