package org.algos.ic;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class MergeArrays {

    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
        System.out.println(Arrays.toString(merge(myArray,alicesArray)));
        System.out.println(Arrays.toString(authorSolution(myArray,alicesArray)));
        System.out.println(mergeSeveralSortedArrays(myArray,alicesArray));
        // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
    }

    //simplest approach
    private static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        int[] resultArray = new int[myArray.length+alicesArray.length];
        int k = 0;
        for(int i=0; i<myArray.length;i++){

           resultArray[k] = myArray[i];
           k++;
        }
        for(int j=0;j<alicesArray.length;j++){

           resultArray[k] = alicesArray[j];
           k++;
        }
        Arrays.sort(resultArray);
        return  resultArray;
    }

    //best approach
    private static int[] merge(int[] myArray, int[] alicesArray) {

        int lengthOfTwoArrays = myArray.length + alicesArray.length;

        int[] result = new int[lengthOfTwoArrays];
        AtomicInteger myArrayIndex = new AtomicInteger(0);
        AtomicInteger aliceArrayIndex = new AtomicInteger(0);

        for(int i=0; i<lengthOfTwoArrays;i++){

           int val =  findMinimumElement(myArray, alicesArray, myArrayIndex, aliceArrayIndex);
           result[i] = val;
        }

        return result;
    }

    //author solution
    private static int[] authorSolution(int[] myArray, int[] allicesArray){

        int[] mergedArrays = new int[myArray.length + allicesArray.length];
        int currentIndexAlices = 0;
        int currentIndexMine = 0;
        int currentIndexMerged = 0;

        while(currentIndexMerged < mergedArrays.length){

            boolean isMyArrayExhausted = currentIndexMine >= myArray.length;
            boolean isAlicesArrayExhausted = currentIndexAlices > allicesArray.length;

            if(!isMyArrayExhausted && (isAlicesArrayExhausted || (myArray[currentIndexMine] < allicesArray[currentIndexAlices]))){

                mergedArrays[currentIndexMerged] = myArray[currentIndexMine];
                currentIndexMine++;
            }

            else {
                mergedArrays[currentIndexMerged] = allicesArray[currentIndexAlices];
                currentIndexAlices++;
            }

            currentIndexMerged++;

        }

        return mergedArrays;

    }

    private static int[] mergeSeveralSortedArrays(int[] ... arrays){

        return arrays[0];

    }

    private static int findMinimumElement(int[] myArray, int[] alicesArray, AtomicInteger myArrayIndex, AtomicInteger aliceArrayIndex){



        boolean isMyArrayExhausted = myArrayIndex.get() >= myArray.length;
        boolean isAlicesArrayExhausted = aliceArrayIndex.get() >= myArray.length;

        int myArrayElement = isMyArrayExhausted ? myArray[0] : myArray[myArrayIndex.get()];
        int aliceArrayElement = isAlicesArrayExhausted ? alicesArray[0] : alicesArray[aliceArrayIndex.get()];


        if(!isMyArrayExhausted && (isAlicesArrayExhausted || (myArrayElement < aliceArrayElement))){
               myArrayIndex.incrementAndGet();
            return myArrayElement;
        }
        else{
            if(!isAlicesArrayExhausted)
                aliceArrayIndex.incrementAndGet();
            return aliceArrayElement;
        }

    }
}
