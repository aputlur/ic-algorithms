package org.algos.ic;

public class LargestSubArray {

    public static void main(String[] args) {
      int result =   findLargestSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("result -> "+ result);
    }

    private static int findLargestSubArray(int[] ints) {

        int currentMax = ints[0];
        int globalMax = ints[0];

        for(int i=0; i<ints.length;i++){

            currentMax = Math.max(ints[i], currentMax + ints[i]);
            if(currentMax > globalMax){
                globalMax = currentMax;
            }
        }
        return globalMax;

    }

}
