package org.algos.ic.leetcode;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

      double result =   findMedianSortedArrays(new int[] { 1, 2}, new int[] { 3 });
        System.out.println("Median of two numbers -> "+ result);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {

            int partitionX = (low + high) / 2;
            //formula to partition to y is -> ((x + y + 1)/2) - partitionX
            int partitionY = ((x + y + 1) / 2) - partitionX;

            //edge cases where partitionX, partitionY run of the elements or reached the length of the array
            //If partitionX is 0 means nothing is there on the left side. Use -INF on the maxLeftX
            //If partitionX is the length of the input array. use the +INF on the minRightX

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                }
                else {
                    return (double) Math.max(maxLeftX,maxLeftY);
                }

            }

            if(maxLeftX > minRightY)
               high = partitionX - 1;
            else
                low = partitionX + 1;

        }

        throw new IllegalArgumentException("Arrays are not sorted");
    }

}
