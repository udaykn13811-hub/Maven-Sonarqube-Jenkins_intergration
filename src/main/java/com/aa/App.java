
package com.aa;

public class App {

    public static String getMessage() {
        return "Welcome to AA Software Technologies";
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(getMessage());
        System.out.println("Result: " + add(10, 20));
    }
}

