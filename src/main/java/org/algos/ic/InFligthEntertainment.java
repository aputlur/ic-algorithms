package org.algos.ic;

import java.util.HashMap;
import java.util.HashSet;

public class InFligthEntertainment {

    public static void main(String[] args) {

        System.out.println(canTwoMoviesFillFlight(new int[] {1, 2, 3, 4, 5, 6}, 7));
    }

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // determine if two movies add up to the flight length
        //simple brute-force solution
         for(int i=0;i<movieLengths.length;i++){

             for(int k=i+1;k<movieLengths.length;k++){

                 if(movieLengths[i]+ movieLengths[k] == flightLength){
                     return true;
                 }
             }
         }

        //two-sum solution

        HashMap<Integer,Integer> map = new HashMap();
        for(int k=0; k<movieLengths.length; k++){
            int nextMovie = flightLength - movieLengths[k];
            if(map.containsKey(nextMovie)){
                return true;
            }
            map.put(movieLengths[k], k);
        }

        // Using HashSet
        HashSet<Integer> movieLengthSeen = new HashSet<Integer>();
        for(int movie : movieLengths){

            int nextMovie = flightLength - movie;
            if(movieLengthSeen.contains(nextMovie)){
                return true;
            }
        }

        return false;
    }



}
