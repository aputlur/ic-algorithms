package org.algos.ic.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

    private static int listToSort[] = new int[] {6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9};

    public static void main(String[] args) {

        print(listToSort);
        System.out.println("\n");
//        quickSort(listToSort, 0, listToSort.length - 1);

        System.out.println(quicksort(Arrays.asList(6, 5, 11, 4, 2, 5, 10, 3, 7, 8, 9)));
//        print(listToSort);
    }

    private static void quickSort(int[] listToSort, int low, int high) {

        if(low >=high) return;

        int pivot = partition(listToSort, low, high);
        quickSort(listToSort, low, pivot-1);
        quickSort(listToSort, pivot + 1, high);

    }

    private static int partition(int[] listToSort, int low, int high) {
        int pivot = listToSort[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (listToSort[l] <= pivot && l < h) {
                l++;
            }
            while (listToSort[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(listToSort, l, h);
            }
        }
        swap(listToSort, low, h);

        System.out.println("Pivot: " + pivot);
        print(listToSort);
        System.out.println("\n");
        return h;
    }

    public static List<Integer> quicksort(List<Integer> numbers) {
        if(numbers.size() < 2) return  numbers;

        int pivot = numbers.get(0);

        List<Integer> lower = new ArrayList<>();
        List<Integer> higher = new ArrayList<>();

        for(int i=1; i < numbers.size() ; i++){

            if(numbers.get(i) < pivot)
                lower.add(numbers.get(i));
            else
                higher.add(numbers.get(i));

        }
        final List<Integer> sorted = quicksort(lower);

        sorted.add(pivot);
        sorted.addAll(quicksort(higher));
        return sorted;

    }

    public static void swap(int[] listToSort, int iIndex, int jIndex) {
        int temp = listToSort[iIndex];
        listToSort[iIndex] = listToSort[jIndex];
        listToSort[jIndex] = temp;
    }

    private static void print(int[] listToSort) {
        for(int k : listToSort){
            System.out.print(k + ",");
        }
    }

//    if (numbers.size() < 2) {
//        return numbers;
//    }
//
//    final Integer pivot = numbers.get(0);
//    final List<Integer> lower = new ArrayList<>();
//    final List<Integer> higher = new ArrayList<>();
//
//        for (int i = 1; i < numbers.size(); i++) {
//        if (numbers.get(i) < pivot) {
//            lower.add(numbers.get(i));
//        } else {
//            higher.add(numbers.get(i));
//        }
//    }
//
//    final List<Integer> sorted = quicksort(lower);
//
//        sorted.add(pivot);
//        sorted.addAll(quicksort(higher));
//
//        return sorted;

}
