package com.packt.java.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<ShoppingItem> books = new ArrayList<>();
        books.add(new ShoppingItem("Java Fundamentals", 10));
        books.add(new ShoppingItem("Java 11 Quick Start", 11));

        List<ShoppingItem> immutableCopy = List.copyOf(books);
        List<ShoppingItem> unmodifiableCopy = Collections.unmodifiableList(books);

        System.out.println(immutableCopy);
        System.out.println(unmodifiableCopy);

        books.remove(0);

        System.out.println(immutableCopy);
        System.out.println(unmodifiableCopy);
    }

    private static final class ShoppingCart {
        private final List<ShoppingItem> mShoppingList;

        public ShoppingCart(List<ShoppingItem> mShoppingList) {
            this.mShoppingList = List.copyOf(mShoppingList);
        }

        public ShoppingCart addItem(ShoppingItem item) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            newList.add(item);
            return new ShoppingCart(newList);
        }

        @Override
        public String toString() {
            return "ShoppingCart{" +
                    "mShoppingList=" + mShoppingList +
                    '}';
        }
    }

    private static final class ShoppingItem {
        private final String name;
        private final int price;

        public ShoppingItem(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ShoppingItem{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
