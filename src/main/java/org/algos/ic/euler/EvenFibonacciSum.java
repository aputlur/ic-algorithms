package org.algos.ic.euler;

public class EvenFibonacciSum {

    public static void main(String[] args) {

        int result = fibonacci(4);
        System.out.println(result);
    }

    private static int fibonacci(int num) {
        int result = 1;
        if (num < 2)
            return 1;

        result+= fibonacci(num - 1) + fibonacci(num - 2);
        return result;
    }

}
