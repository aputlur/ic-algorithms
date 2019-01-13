package org.algos.ic;

public class ReverseWords {

    public static void reverseWords(char[] message) {

        reverseWord(message, 0, message.length - 1);
        int currentWordStartIndex = 0;

        for (int i = 0; i <=message.length; i++) {

            if (message.length == i || message[i] == ' ') {
                reverseWord(message, currentWordStartIndex, i-1);
                currentWordStartIndex = i + 1;
            }
        }
    }

    static void reverseWord(char[] message, int first, int last) {

        while (first < last) {

            char temp = message[first];
            message[first] = message[last];
            message[last] = temp;
            first++;
            last--;

        }
    }

    public static void main(String[] args) {
        char[] input = "three two one".toCharArray();
        reverseWords(input);
        System.out.println(input);
    }

}
