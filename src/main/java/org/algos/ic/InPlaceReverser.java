package org.algos.ic;

public class InPlaceReverser {

    public static void main(String[] args) {
        char[] result = new char[] {'A','N','I','L'};
        doInplaceReverse(result);
        System.out.println(result);

        int[] input = new int[]{1,1,1,0,0,1};
        reArrangeZerosAndOnes(input);
        for(int o : input){
            System.out.print(o + ",");
        }
    }



    private static void reArrangeZerosAndOnes(int[] input){

        int start = 0;
        int end = input.length-1;
        while(start < end){
            if(input[start] > input[end]) {
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
            }
            start++;
            end--;
        }
    }



    /**
     * In-place algorithms modifies the given input with-out using any extra space.
     * @param arrayOfChars
     */



    private static void doInplaceReverse(char[] arrayOfChars){

        int leftIndex = 0;
        int rightIndex = arrayOfChars.length-1;

        while(leftIndex < rightIndex){

            char temp = arrayOfChars[leftIndex];
            arrayOfChars[leftIndex] = arrayOfChars[rightIndex];
            arrayOfChars[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
    }
}
