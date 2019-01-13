package org.algos.ic.lc;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] result = bruteForceApproach(new int[] { 2, 7, 9, 1 }, 9);
        System.out.println("Brute-force result -> " + result[0] + "," + result[1]);

        int[] result1 = twoPassApproach(new int[] { 2, 7, 9, 1 }, 9);
        System.out.println("Two-pass result -> " + result1[0] + "," + result1[1]);

        int[] result2 = singlePassApproach(new int[] { 2, 7, 9, 1 }, 9);
        System.out.println("Single-pass result -> " + result2[0] + "," + result2[1]);
    }

    //Two pass-solution using hash-table
    private static int[] twoPassApproach(int[] num, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            hashMap.put(num[i], i);
        }

        for (int j = 0; j < num.length; j++) {
            int complement = target - num[j];
            if (hashMap.containsKey(complement) && num[j] + complement == target)
                return new int[] { hashMap.get(complement), j };
        }

        throw new IllegalArgumentException("No two-sum solution found ");
    }

    // Single-pass solution
    private static int[] singlePassApproach(int[] num, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {

            int complement = target - num[i];

            if (hashMap.containsKey(complement))
                return new int[] { hashMap.get(complement), i };
            else
                hashMap.put(num[i], i);
        }
        throw new IllegalArgumentException("No Two sum solution found");
    }

    private static int[] bruteForceApproach(int[] input, int target) {

        for (int outer = 0; outer < input.length; outer++) {

            for (int inner = outer + 1; inner < input.length; inner++) {

                if (input[outer] + input[inner] == target)
                    return new int[] { inner, outer };

            }
        }
        throw new IllegalArgumentException("No Two sum solution found");
    }
}
