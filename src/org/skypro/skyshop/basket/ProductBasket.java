package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket(List<Product> products) {
        this.products = new HashMap<>();

        for (Product p : products) {
            List<Product> valList = new ArrayList<Product>();
            valList.add(p);
            this.products.put(p.getName(), valList);
        }
    }

    public void addProduct(Product product) {
        ArrayList<Product> currVal = (ArrayList<Product>) products.putIfAbsent(product.getName(), List.of(product));
        currVal.add(product);

        if (!(currVal == null)) {
            products.put(product.getName(), currVal);
        }
    }

    public int getTotalCost() {
        int result = 0;

        for (List<Product> currVal : products.values()) {
            for (Product p : currVal) {
                result += p.getCost();
            }

        }
        return result;
    }

    public String toString() {
        String result = "";
        int specialProductsCount = 0;

        for (List<Product> currVal : products.values()) {
            for (Product currentProduct : currVal) {
                result = result + currentProduct.toString() + "\n";

                if (currentProduct.isSpecial()) {
                    specialProductsCount++;
                }
            }
        }

        if (result.isBlank()) {
            result = "в корзине пусто";
        } else {
            result = result + "Итого: " + getTotalCost();

            if (specialProductsCount > 0) {
                result += "\n" + "Специальных товаров: " + specialProductsCount;
            }
        }

        return result;
    }

    public String printBasket() {
        String result = "";

        for (List<Product> currVal : products.values()) {
            for (Product currentProduct : currVal) {
                result = result + currentProduct.toString() + "\n";
            }
        }

        if (result.isBlank()) {
            return "В корзине пусто";
        } else {
            return result;
        }
    }

    public boolean isProductInBasket(String productName) {
        for (List<Product> currVal : products.values()) {
            for (Product p : currVal) {
                if (p.getName().toUpperCase()
                        .equals(productName.toUpperCase())) {
                    return true;
                }
            }
        }

        return false;
    }

    public void purgeBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> result = new ArrayList<>();

        for (String key : products.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                List<Product> removed = products.remove(key);

                for (Product p : removed) {
                    result.add(p);
                }

                break;
            }
        }
        return result;
    }
}
