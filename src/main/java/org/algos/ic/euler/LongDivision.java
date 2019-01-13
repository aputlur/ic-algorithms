package org.algos.ic.euler;

public class LongDivision {

    public static void main(String[] args) {

        //If we don't denote 24 with 'L', it computes in integer values, hence prints 5 instead of 100 when we don't use.
        final long MICRO_SECONDS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLS_PER_DAY = 24L * 60 * 60 * 1000;

        System.out.println(MICRO_SECONDS_PER_DAY/MILLS_PER_DAY);
    }

}
