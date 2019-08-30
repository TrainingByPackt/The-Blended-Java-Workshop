package com.packtpub.recursion;

public class Fibonacci {
    public static int fibonacci(int number) {
        if(number == 0) {
            return number;
        } else if (number == 1) {
            return 1;
        } else {
            return (fibonacci(number - 1) + fibonacci(number - 2));
        }
    }
    //Fib: 0 1 1 2 3 5 8
    public static void main(String[] args) {
        for(int i = 0; i < 18; i++)
            System.out.println(fibonacci(i));
    }
}
