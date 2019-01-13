package org.algos.ic.euler;

public class HexProblem {

    public static void main(String[] args) {
        //This just prints the cafebabe because, here computation happening with int and long
        System.out.println(
                Long.toHexString(0x100000000L + 0xcafebabe));

        System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
    }
}
