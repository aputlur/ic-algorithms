package org.algos.ic;

public class Fibonacci {

    public static void main(String[] args) {

       int result =  fib(5);
        System.out.println("result -> "+ result);
    }

    private static int fib(int num){

        System.out.println("calling fib("+ num + ")");

        //base-condition
        if(num == 0 || num == 1) return num;

        int result1 =  fib(num-1);
//        System.out.println("starting n-2, what is n here = "+ num);
        int result =   result1 + fib(num-2);

        return result;
    }
}
