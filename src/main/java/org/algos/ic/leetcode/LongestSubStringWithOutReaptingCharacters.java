package org.algos.ic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutReaptingCharacters {

    private static Map<Integer, Character> map = new HashMap<>();

    public static void main(String[] args) {
        String input = "abcabcdefghbabcabcdefghijb";
//        String input = "bbbbb";
        int result = findLongestSubString(input);
        System.out.println("result -> "+ result);
    }

    private static int findLongestSubString(String input) {
        //input = abcabcbb

        int currentCount = 0;
        int globalCount = 0;
        for(int currentIndex = 0; currentIndex < input.length()-1; currentIndex++) {

            Character currentCharacter = input.charAt(currentIndex);
            boolean doesItExists = doesCharacterExists(currentCharacter);
            boolean isIndexCont = isIndexCont(currentIndex, input);

            if (doesItExists && isIndexCont) {
                currentCount = currentCount + 1;
                globalCount = Math.max(currentCount, globalCount);
                map.put(currentIndex, currentCharacter);
                System.out.println("currentCount -> "+ currentCount + " CurrentCharacter "+ currentCharacter + " GlobalCount -> "+ globalCount);
            } else {
                map.clear();
                map.put(currentIndex, currentCharacter);
                currentCount = 1;

            }

        }
        return globalCount;
    }

    //Index should be cont..
    private static boolean isIndexCont(int currentIndex, String input){
        if(currentIndex <=0 || map.isEmpty()) return true;

        if(map.get(currentIndex-1) == input.charAt(currentIndex-1)){
            return true;
        }
        return false;
    }

    //it should not be duplicate
    private static boolean doesCharacterExists(Character currentCharacter){

        for(Character c : map.values()){
            if(c == currentCharacter) return false;
        }

        return true;
    }

}
