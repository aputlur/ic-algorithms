package org.algos.ic;

import java.util.Arrays;

public class CoinChangeProblem {

    public static void main(String[] args) {
       int result =  changePossibilitiesTopDown(4,new int[]{1,2});
//       int result =  changePossibilitiesBottomUp(4,new int[]{3,2,1});
        System.out.println("result -> "+ result);
    }
    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    /**
     * amt = 4, d = {1,2,3,4}
     * result = {4+1}
     *
     * result[0] = {1,2,1,1,1}
     * coin = 2
     * higherAmount = 2
     * higherAmountRemainder = 2-2 => 0
     * result[1] += result[0]
     *
     * higherAmount = 3
     * remainder = higherAmount - coin => 3 -2 = 1
     * result[3]+= result[1]
     *
     * higherAmount = 3
     * r = 3 - 1 = 2
     * result[2]+= result[1]
     *
     * higherAmount = 4
     * r = 4-1 =3
     * result[4]+=result[3]
     *
     *
     */
    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount + 1];  // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }
    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) {
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) {
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length) {
            return 0;
        }

        System.out.printf("checking ways to make %d with %s\n",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        currentIndex, denominations.length)));

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations,
                    currentIndex + 1);
            amountLeft -= currentCoin;
        }

        return numPossibilities;
    }

}
