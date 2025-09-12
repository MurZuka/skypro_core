package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket(List<Product> products) {
        this.products = new HashMap<>();

        for (Product p : products) {
            this.products.put(p.getName(), new ArrayList<>() {{
                add(p);
            }});
        }
    }

    public void addProduct(Product product) {
        List<Product> currVal = products.putIfAbsent(product.getName(), List.of(product));

        currVal.add(product);

        if (!(currVal == null)) {
            products.put(product.getName(), currVal);
        }
    }

    public int getTotalCost() {
        return products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getCost)
                .sum();
    }

    public String toString() {
        String result = products.values().stream().flatMap(Collection::stream)
                .map(Product::toString)
                .collect(Collectors.joining("\n"));

        if (result.isBlank()) {
            result = "в корзине пусто";
        } else {
            result = result + "\nИтого: " + getTotalCost();

            long specialProductsCount = getSpecialCount();

            if (specialProductsCount > 0) {
                result += "\nСпециальных товаров: " + specialProductsCount;
            }
        }

        return result;
    }

    private long getSpecialCount() {
        return products.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public String printBasket() {
        StringBuilder sb = new StringBuilder();

        products.values().stream().flatMap(Collection::stream)
                .forEach(p -> sb.append(p.toString()).append("\n"));

        String result = sb.toString();

        if (result.isBlank()) {
            return "В корзине пусто";
        } else {
            return result;
        }
    }

    public boolean isProductInBasket(String productName) {
        return products.values().stream().flatMap(Collection::stream)
                .anyMatch(p -> p.getName().toUpperCase().equals(productName.toUpperCase()));
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
