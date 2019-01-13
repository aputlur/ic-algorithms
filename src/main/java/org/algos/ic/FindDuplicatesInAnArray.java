package org.algos.ic;

/**
 *
 * The problem is that we want to find duplicates in a one-dimensional array of integers in O(N)
 * running time where the integer values are smaller than the length of the array!
 *
 */
public class FindDuplicatesInAnArray {

    public static void main(String[] args) {

        int[] input = new int[] {2,3,1,2,4,3};
        findDuplicates(input);
    }

    private static void findDuplicates(int[] input) {

        for(int index = 0; index < input.length; index++){

            int currentIndexValue = Math.abs(input[index]);
            if(input[currentIndexValue] > 0){
                // input[Math.abs(input[0])] ==> input[2] ==> 1 ==> Mark as -1
                // input[Math.abs(input[1])] ==> input[3] ==> 2 ==> Mark as -2
                // input[Math.abs(input[2])] ==> input[1] ==> 3 ==> Mark as -3
                // input[Math.abs(input[3])] ==> input[2] ==>-1 ==> Not positive hence input[3] is duplicate.
                // input[Math.abs(input[4])] ==> input[4] ==> 4 ==> Mark as -4
                // input[Math.abs(input[5])] ==> input[3] ==> -2 ==> Not a positive integer hence input[5] is duplicate.

                input[currentIndexValue] = -input[currentIndexValue];

            }
            else{
                System.out.println("found duplicate value in one-dimensional array -> "+ currentIndexValue);
            }
        }
    }

}
