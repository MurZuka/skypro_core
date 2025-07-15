package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product p1 = new Product("Телевизор", 555);
        Product p2 = new Product("Микроволновка", 3000);
        Product p3 = new Product("Холодильник", 720);

        ProductBasket basket = new ProductBasket(new Product[]{p1, p2, p3});

        //Добавление продукта в корзину.
        basket.addProduct(p3);
        basket.addProduct(p3);

        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.addProduct(p3);

        //Печать содержимого корзины с несколькими товарами.
        System.out.println(basket);

        //Получение стоимости корзины с несколькими товарами.
        System.out.println(basket.getTotalCost());

        //Поиск товара, который есть в корзине.
        System.out.println(basket.isProductInBasket("Микроволновка"));

        //Поиск товара, которого нет в корзине.
        System.out.println(basket.isProductInBasket("Вундервафля"));

        //Очистка корзины.
        basket.purgeBasket();

        //Печать содержимого пустой корзины.
        System.out.println(basket);

        //Получение стоимости пустой корзины.
        System.out.println(basket.getTotalCost());

        //Поиск товара по имени в пустой корзине.
        System.out.println(basket.isProductInBasket("Микроволновка"));
    }
}
