package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private ArrayList<Product> products;

    public ProductBasket(List<Product> products) {
        this.products = new ArrayList<>();
        this.products.addAll(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int result = 0;

        for (Product p : products) {
            result += p.getCost();
        }

        return result;
    }

    public String toString() {
        String result = "";
        int specialProductsCount = 0;

        for (Product currentProduct : products) {
            result = result + currentProduct.toString() + "\n";

            if (currentProduct.isSpecial()) {
                specialProductsCount++;
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

        for (Product currentProduct : products) {
            result = result + currentProduct.toString() + "\n";
        }

        if (result.isBlank()) {
            return "В корзине пусто";
        } else {
            return result;
        }
    }

    public boolean isProductInBasket(String productName) {
        for (Product p : products) {
            if (p.getName().toUpperCase()
                    .equals(productName.toUpperCase())) {
                return true;
            }
        }

        return false;
    }

    public void purgeBasket() {
        products.clear();
    }

    public List<Product> removeProductByName(String name) {
        List<Product> result = new ArrayList<>();
        Iterator it = products.iterator();
        Product currentProduct;

        if (isProductInBasket(name)) {
            while (it.hasNext()) {
                currentProduct = (Product) it.next();

                if (currentProduct.getName().toUpperCase()
                        .equals(name.toUpperCase())) {
                    result.add(currentProduct);
                    it.remove();
                }
            }
        }

        return result;
    }
}
