package org.algos.ic.lc;


public class InsertionSort {

    public static void main(String[] args) {
        insertionSort(new int[]{0,1,0,2,3});
    }

    private static void insertionSort(int[] input){

        for(int i=0;i<input.length-1;i++){

            for(int j=i+1; j>0;j--){
                if(input[j] < input[j-1]){
                    int tmp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = tmp;
                }
                else{
                    break;
                }
            }
        }
        for(int k : input)
        System.out.println(k);

    }

}
