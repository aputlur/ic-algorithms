package org.algos.ic;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = { 1,3 };
        int[] arr2 = { 2,4};
        int[] arr3 = {};

        int[][] ints = { arr1,arr2,arr3 };
        int[] result = mergeKSortedArray(ints);
        System.out.println(Arrays.toString(result));
    }

    // create QueueNode class

    private static int[] mergeKSortedArray(int[][] arrays) {

//        pQueue = {2,2,6},{1,0,7},{0,0,10};
//        size =12;
//        result = {4,5, 6};
//        currentIndex = 2;
//        currentArrayLength = 3;


        //create PriorityQueue
        PriorityQueue<QueueNode> pQueue = new PriorityQueue<>();
        //record the number of elements to create the result array
        int size = 0;

        //iterate over 2-dimensional array
        for(int k=0; k<arrays.length;k++){
            size+= arrays[k].length;

            if(arrays[k].length > 0){
                pQueue.add(new QueueNode(k, 0, arrays[k][0]));
            }
        }
        System.out.println("size -> "+ size);

        //initialize result array
        int[] result = new int[size];
        int currentIndex = 0;
        while(!pQueue.isEmpty()){

            QueueNode current = pQueue.poll();
            result[currentIndex] = current.value;
            currentIndex++;


           int newIndex = current.index+1;
           if(newIndex < arrays[current.array].length){
               pQueue.add(new QueueNode(current.array,newIndex,arrays[current.array][newIndex]));
           }

        }
        return result;
    }


    static class QueueNode implements Comparable<QueueNode>{

        private int array;
        private int index;
        private int value;

        public QueueNode(int array, int index, int value){

            this.array = array;
            this.index = index;
            this.value = value;
        }

        public int compareTo(QueueNode n){

            if(value > n.value) return 1;
            else if(value < n.value) return -1;
            return 0;
        }
    }





}
