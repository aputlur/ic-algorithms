package org.algos.ic.euler;

import java.math.BigDecimal;

public class TimeForAChange {

    public static void main(String[] args) {
        double actual = 2.00f;
        double cost = 1.10f;
        System.out.println(actual - cost);
        System.out.printf("%.2f%n", actual - cost);
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));

//        In summary, avoid float and double where exact answers are required;
//        for monetary calculations, use int,long,or BigDecimal.For language designers, consider providing linguistic support for decimal arithmetic.One approach is to offer limited support for
//        operator overloading, so that arithmetic operators can be made to work with numerical reference types, such as BigDecimal.Another approach is to provide a primitive decimal type, as did COBOL
//        and PL/I.
    }

}
