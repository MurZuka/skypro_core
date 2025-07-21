package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct p1 = new SimpleProduct("Телевизор", 555);
        SimpleProduct p2 = new SimpleProduct("Микроволновка", 3000);
        SimpleProduct p3 = new SimpleProduct("Холодильник", 720);
        FixPriceProduct p4 = new FixPriceProduct("Фиксированный чайник");
        DiscountedProduct p5 = new DiscountedProduct("Скидочный тостер",  350, (byte) 5);

        ProductBasket basket = new ProductBasket(new Product[]{p1, p2, p3, p4, p5});

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
