package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        SimpleProduct p1 = new SimpleProduct("Телевизор", 555);
        SimpleProduct p2 = new SimpleProduct("Микроволновка", 3000);
        SimpleProduct p3 = new SimpleProduct("Холодильник", 720);
        FixPriceProduct p4 = new FixPriceProduct("Фиксированный чайник");
        DiscountedProduct p5 = new DiscountedProduct("Скидочный тостер", 100, (byte) 5);
        DiscountedProduct p6 = new DiscountedProduct("Телевизор", 99, (byte) 5);

        Article a1 = new Article("Статья 1", "Текст статьи раз");
        Article a2 = new Article("Описание 2", "Текст описания два");

        List<Searchable> toEngine = List.of(p1, p2, p3, p4, p5, a1, a2);
        SearchEngine searchEngine = new SearchEngine(toEngine, toEngine.size());

        System.out.println(searchEngine.search("ый"));
        System.out.println(searchEngine.search("микров"));

        try {
            Product incorrectNameProduct = new SimpleProduct("", 0);
            Product incorrectBasePriceProduct = new DiscountedProduct("ss", -1, (byte) 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(searchEngine.getBestResult("ый"));

        ProductBasket basket = new ProductBasket(List.of(p1, p2, p3, p4, p5, p6));

        List<Product> checkRemoved = basket.removeProductByName("телевизор");

        if (checkRemoved.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println(checkRemoved);
        }

        System.out.println(basket.printBasket());
        System.out.println(basket.isProductInBasket("холодильник"));
    }
}
