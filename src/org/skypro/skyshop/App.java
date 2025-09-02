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

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        SimpleProduct p1 = new SimpleProduct("Телевизор", 555);
        SimpleProduct p2 = new SimpleProduct("Микроволновка", 3000);
        SimpleProduct p3 = new SimpleProduct("Холодильник", 720);
        FixPriceProduct p4 = new FixPriceProduct("Фиксированный чайник");
        DiscountedProduct p5 = new DiscountedProduct("Скидочный тостер", 100, (byte) 5);

        Article a1 = new Article("Статья 1", "Текст статьи раз");
        Article a2 = new Article("Описание 2", "Текст описания два");

        Searchable[] toEngine = new Searchable[]{p1, p2, p3, p4, p5, a1, a2};
        SearchEngine searchEngine = new SearchEngine(toEngine, toEngine.length);

        System.out.println(Arrays.toString(searchEngine.search("два")));
        System.out.println(Arrays.toString(searchEngine.search("микров")));

        try {
            Product incorrectNameProduct = new SimpleProduct("", 0);
            Product incorrectBasePriceProduct = new DiscountedProduct("ss", -1, (byte) 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(searchEngine.getBestResult("ый"));
    }
}
