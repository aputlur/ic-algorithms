package org.algos.ic.puzzlers;

public class Oddity {

    public static void main(String[] args) {

      boolean result =   isOdd(-1);
        System.out.println("result -> "+ result);
        System.out.println((-2147483648 & -2147483648)==0);
    }

    /**
     * This does not work in negative integer cases.
     * @param i
     * @return
     */
    private static boolean isOdd(int i) {

     return i % 2 == 1;
    }

    /**
     * Simple way to fix above is check with zero instead 1.
     */

    private static boolean isOdd1(int num){
        return num % 2 !=0;
    }

    /**
     * In case of performance-centric applications, use the below approach.
     */

    private static boolean isOddCheck(int num){

        return (num & 1)!=0;
    }
}
