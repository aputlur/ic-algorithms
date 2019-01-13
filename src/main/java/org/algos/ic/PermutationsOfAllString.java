package org.algos.ic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PermutationsOfAllString {

    public static void main(String[] args) {
//        System.out.println(findPermutationsOfAllString("abcdefgh"));
       findPermutationsOfAllString("abcdefghijk");
    }

    private static Set<String> findPermutationsOfAllString(String inputString) {

        //since return type is Set, creating the same to match.
        if(inputString.length() <=1) return new HashSet<>(Collections.singletonList(inputString));

        String allCharacterExceptLast = inputString.substring(0, inputString.length()-1);
        char lastChar = inputString.charAt(inputString.length()-1);
//        System.out.println("last-char = "+ lastChar);

        //make recursive call to to divide more sub-problems
       Set<String> allCharacterPermutationsExceptLast =  findPermutationsOfAllString(allCharacterExceptLast);
        //ca -> allCharactersExceptLast = c and lastChar = a. Since it met the base-condition, record permutations using lastChar
//        System.out.println("all characters except last -> "+ allCharacterPermutationsExceptLast);

        Set<String> permutations = new HashSet<>();
        System.out.println("started processing for ");
        System.out.print("when number of strings are :"+ allCharacterPermutationsExceptLast.size() );
        int count =0;
        for(String allCharacterPermutationExceptLast : allCharacterPermutationsExceptLast){
                count++;
            for(int position = 0; position <= allCharacterExceptLast.length();position++) {
                //subString(0,position) + lastChar + subString(position);
                       String zeroToPosition = allCharacterPermutationExceptLast.substring(0,position);
                       String lastString =  allCharacterPermutationExceptLast.substring(position);
                       permutations.add(zeroToPosition + lastChar + lastString);
                       count++;

                //""+ a + c
                //c + a + ""
                //"" + b + "ca"
                //"c" + "b" + a
                // "ca" + b + ""
                //
            }

        }
        System.out.print(" looping ->"+ count + " :times");
        return permutations;
    }

}
