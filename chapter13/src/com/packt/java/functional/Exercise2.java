package com.packt.java.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Exercise2 {
    public static void main(String[] args) {
        ShoppingCart myFirstCart = new ShoppingCart(new ArrayList<>());
        ShoppingCart mySecondCart = myFirstCart.addItem(
                new ShoppingItem("Chair", 150));
        ShoppingCart myThirdCart = mySecondCart.addItem(
                new ShoppingItem("Table",350));

        System.out.println("First " + myFirstCart);
        System.out.println("Second " + mySecondCart);
        System.out.println("Third " + myThirdCart);

        ShoppingCart myFourthCart = myThirdCart.removeItem(
                new ShoppingItem("Table",350));

        System.out.println("Fourth " + myFourthCart);
        System.out.println("Third " + myThirdCart);

        ShoppingCart myBulkCart = new ShoppingCart(new ArrayList<>());
        ShoppingCart myBulkWithTwoIn = myBulkCart.addItem(
                new ShoppingItem("Chair", 150),
                new ShoppingItem("Table", 350));

        System.out.println("Bulk " + myBulkWithTwoIn);
    }

    private static final class ShoppingCart {
        private final List<ShoppingItem> mShoppingList;

        public ShoppingCart(List<ShoppingItem> mShoppingList) {
            this.mShoppingList = Collections.unmodifiableList(mShoppingList);
        }

        public ShoppingCart addItem(ShoppingItem ... items) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            for (ShoppingItem item : items) {
                newList.add(item);
            }
            return new ShoppingCart(newList);
        }

        public ShoppingCart addItem(ShoppingItem item, int quantity) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            for (int i=0; i<quantity; i++) {
                newList.add(item);
            }
            return new ShoppingCart(newList);
        }

        public ShoppingCart removeItem(ShoppingItem item, int quantity) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            for (int i=0; i<quantity; i++) {
                newList.remove(item);
            }
            return new ShoppingCart(newList);
        }

        public ShoppingCart removeItem(ShoppingItem item) {
            List<ShoppingItem> newList = new ArrayList<>(mShoppingList);
            newList.remove(item);
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
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ShoppingItem that = (ShoppingItem) o;
            return price == that.price &&
                    Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price);
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
