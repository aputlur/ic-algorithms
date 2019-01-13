package org.algos.ic.lc;


public class MergeSort {

    private static int listToSort[] = new int[] {3, 5, 6, 8, 10, 1, 2, 4, 7, 9};

    public static void main(String[] args) {
        print(listToSort);
        System.out.println("\n");
        mergeSort(listToSort);
        print(listToSort);
    }

    private static void print(int[] listToSort) {
        for(int k : listToSort){
            System.out.print(k + ",");
        }
    }

    private static void mergeSort(int[] listToSort) {

        //base-condition
        if(listToSort.length == 1) return;

        int midIndex = listToSort.length/2 + (listToSort.length%2);
        int[] listFirstHalf = new int[midIndex];
        int[] listSecondHalf = new int[listToSort.length - midIndex];

        split(listToSort, listFirstHalf, listSecondHalf);

        mergeSort(listFirstHalf);
        mergeSort(listSecondHalf);

        merge(listToSort, listFirstHalf, listSecondHalf);

    }
    private static void split(int[] listToSort, int[] firstHalf, int[] secondHalf){
        int index = 0;

        for(int k : listToSort){

            if(index < firstHalf.length){
                firstHalf[index] = listToSort[index];
            }
            else{
                secondHalf[index - firstHalf.length] = listToSort[index];
            }
            index++;
        }
    }

    private static void merge(int[] listToSort, int[] firstHalf, int[] secondHalf) {

        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;

        while (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {

            if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {

                listToSort[mergeIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;

            } else if (secondHalfIndex < secondHalf.length) {
                listToSort[mergeIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;

        }

        if (firstHalfIndex < firstHalf.length){
            while (mergeIndex < listToSort.length) {
                listToSort[mergeIndex++] = firstHalf[firstHalfIndex++];
            }
        }

        if(secondHalfIndex < secondHalf.length){
            while(mergeIndex < listToSort.length){
                listToSort[mergeIndex++] = secondHalf[secondHalfIndex++];
            }
        }



    }



}
