package org.algos.ic.lc;

public class BubbleSort {

    public static void main(String[] args) {
        bubbleSort(new int[] {6,5,4,3,2,1});
        forLoopBubbleSort(new int[] {6,5,4,3,2,1});
    }

    public static void bubbleSort(int[] numbers) {
        boolean numbersSwitched;


        do{
            numbersSwitched = false;
            for(int i=0; i< numbers.length-1; i++){

                if(numbers[i+1] < numbers[i]){
                    int tmp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = tmp;
                    numbersSwitched = true;
                }
            }
        }
        while(numbersSwitched);
        for(int k : numbers){
            System.out.println(" k valu -> "+ k);
        }

    }

    public static void forLoopBubbleSort(int[] numbers){

        for(int i=0;i<numbers.length-1;i++){

            for(int j=i+1; j<numbers.length;j++){
                if(numbers[i] > numbers[j]) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        for(int k : numbers){
            System.out.println(" k valu -> "+ k);
        }

    }

}
