package org.algos.ic;

public class FindRotationalPoint {

    public static int findRotationPoint(String[] words) {

        // G, F, E, D, A, B, C
        // find the rotation point in the array
        String firstWord = words[0];
        int floorIndex = 0;
        int ceilingIndex = words.length-1;

        while(floorIndex < ceilingIndex){

            int guessIndex = (floorIndex + ceilingIndex)/2;

            if(words[guessIndex] .compareTo(firstWord) >=0 ){
                //right
                floorIndex = guessIndex;
            }
            else {
                ceilingIndex = guessIndex;
            }

            if(floorIndex +1 == ceilingIndex){
                break;
            }
        }

        return ceilingIndex;
    }




    private static int findRotationPointForAll(String[] words){

        int lowerBound = 0;
        int upperBound = words.length-1;

        String firstWord = words[0];

        while(lowerBound < upperBound){


            int middle = (lowerBound + upperBound)/2;
            System.out.println("lowerBound -> "+ lowerBound + " upperBound -> "+ upperBound + " middle element -> "+ middle);

            if(words[middle].compareTo(firstWord) >= 0){
                //go right
                lowerBound = middle;
            }
            else {
                upperBound = middle;

            }
            System.out.println("lowerBound -> "+ lowerBound  + " upperBound -> "+ upperBound + " middle element -> "+ middle);
            if(lowerBound + 1 == upperBound){
               break;
            }

        }
        return words[lowerBound].compareTo(words[upperBound]) >= 0 ? upperBound : 0;

    }

    public static void main(String[] args) {
        ;
//        int result = findRotationPointForAll(new String[] {"zoo","zooo","xelon","yellow","cape", "cake","ape", "beep","cap"});
        int result = findRotationPointForAll(new String[]{"grape", "orange", "plum","radish", "apple"});
        System.out.println("result -> "+ result);
    }





}
