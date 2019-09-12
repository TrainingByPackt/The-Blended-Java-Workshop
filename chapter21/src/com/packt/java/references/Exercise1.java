package com.packt.java.references;

import java.lang.ref.WeakReference;

public class Exercise1 {

    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        System.out.println(myObject);

        WeakReference<MyObject> weakReference = new WeakReference<>(myObject);
        MyObject myObject2 = weakReference.get();
        System.out.println(myObject2);

        myObject = null;
        myObject2 = null;

        System.gc();

        MyObject myObject3 = weakReference.get();
        System.out.println(myObject3);
    }
}
