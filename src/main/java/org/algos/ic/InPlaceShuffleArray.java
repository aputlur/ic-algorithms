package org.algos.ic;

import java.util.Arrays;
import java.util.Random;

public class InPlaceShuffleArray {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        System.out.println("floor -> "+ floor + " ceiling -> "+ ceiling);
        int c = rand.nextInt(((ceiling - floor)));
        System.out.println("ceiling business -> " + c);
        int result = rand.nextInt((ceiling - floor) + 1) + floor;
        System.out.println("result -> "+ result);
        return result;
    }

    public static void shuffle(int[] theArray) {

        // shuffle the input in place
        if(theArray.length <= 1){
            return;
        }

        for(int indexWeAreChoosingFor = 0;
            indexWeAreChoosingFor < theArray.length -1; indexWeAreChoosingFor++){

            int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length-1);

            if(randomChoiceIndex != indexWeAreChoosingFor){
                int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
                theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
                theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
            }
        }

    }

    // initial array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    // shuffled array: [7, 1, 9, 8, 10, 4, 2, 3, 6, 5]

    // initial array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    // shuffled array: [1, 7, 10, 4, 5, 3, 8, 2, 9, 6]

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }

}
