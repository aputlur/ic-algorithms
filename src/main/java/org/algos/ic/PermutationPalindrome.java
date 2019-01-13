package org.algos.ic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PermutationPalindrome {

    public static void main(String[] args) {

        //        System.out.println(isGivenStringPermutationPalindrome("civic","iivcc"));
        System.out.println(hasPalindromePermutation("cbb"));
//        System.out.println(bestSolution("abbccdda"));
    }

    public static boolean bestSolution(String input) {

        Set<Character> unPairedCharacters = new HashSet<Character>();

        for (char c : input.toCharArray()) {

            if (unPairedCharacters.contains(c)) {
                unPairedCharacters.remove(c);
            } else {
                unPairedCharacters.add(c);
            }

        }
        return unPairedCharacters.size() <= 1;
    }

    static boolean isGivenStringPermutationPalindrome(String actual, String input) {

        Set<String> set = new LinkedHashSet<String>();
        set.add(input);
        for (int k = 1; k < input.length(); k++) {
            StringBuilder sb = new StringBuilder();
            sb.append(input.charAt(k));

            if (k > 0) {
                sb.append(input, k - k, k);
            }
            sb.append(input, k + 1, input.length());
            set.add(sb.toString());
        }
        System.out.println(set);
        return set.contains(actual);
    }

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        HashMap<Character, Integer> charactersMap = new HashMap();

        for (int i = 0; i < theString.length(); i++) {

            Character val = theString.charAt(i);
            if (charactersMap.containsKey(val)) {
                int count = charactersMap.get(val);
                charactersMap.put(val, count + 1);
            } else {
                charactersMap.put(val, 1);
            }
        }

        int oddNumberCount = 0;
        for (int vals : charactersMap.values()) {
            if (vals % 2 != 0)
                oddNumberCount++;
        }

        //aabccbdd
        //abcddcba

        return oddNumberCount <= 1;
    }

    static boolean isItPalindrome(String input) {

        int startIndex = 0;
        int endIndex = input.length() - 1;

        while (startIndex < endIndex) {

            Character c1 = input.charAt(startIndex);
            Character c2 = input.charAt(endIndex);
            if (c1 != c2)
                return false;
            startIndex++;
            endIndex--;
        }

        return true;
    }

}
