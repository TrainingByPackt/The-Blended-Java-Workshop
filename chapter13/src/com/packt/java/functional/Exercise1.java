package com.packt.java.functional;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {
	    System.out.println(sum(2,3));
	    System.out.println(sum(2,3));
	    System.out.println(sum(2,3));

	    System.out.println(sum(1, 2, 3, 4));
    }

    static int sum(int ... values) {
        int total = 0;
        for (int value:values) {
            total += value;
        }
        return total;
    }
}
