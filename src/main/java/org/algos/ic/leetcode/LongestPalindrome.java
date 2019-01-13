package org.algos.ic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindrome {

    public static void main(String[] args) {

        //        String result = longestPalindrome("cbbd");
        String result1 = longestPalindromeUsingDynamicProgramming("bbc");
        System.out.println("output -> " + result1);
    }

    private static String longestPalindromeUsingDynamicProgramming(String s) {

        if (s == null || s.length() < 2)
            return s;
        int length = s.length();

        int left = 0;
        int right = 0;

        boolean[][] isPalindrome = new boolean[length][length];

        //i is backward
        //j is forward

        for (int forward = 1; forward < s.length(); forward++) {

            for (int backword = 0; backword < forward; backword++) {

                boolean innerWordPalindrome = isPalindrome[backword + 1][forward - 1] || forward - backword <= 2;

                if (s.charAt(backword) == s.charAt(forward) && innerWordPalindrome) {
                    isPalindrome[backword][forward] = true;

                    if (forward - backword > right - left) {
                        left = backword;
                        right = forward;
                    }
                }
            }
        }

        return s.substring(left, right + 1);

    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static String longestPalindromeAttempt(String s) {

        String[] result = new String[1];
        //if input is length of 1
        result[0] = String.valueOf(s.charAt(0));

        for (int currentIndex = 1; currentIndex < s.length(); currentIndex++) {

            String toBeVerified = s.substring(0, currentIndex + 1);
            boolean isPalindromString = isValidPalindrome(toBeVerified);

            if (isPalindromString && result[0].length() < toBeVerified.length())
                result[0] = toBeVerified;
        }

        return result[0];
    }

    private static boolean isValidPalindrome(String input) {
        System.out.println("substring -> " + input);
        int start = 0;
        int end = input.length() - 1;
        //baadbcb
        while (start < end) {
            if (input.charAt(start) == input.charAt(end)) {
                return true;
            }
            start++;
            end--;
        }
        return false;
    }
}
