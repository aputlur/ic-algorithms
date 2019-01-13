package org.algos.ic.euler;

public class ConvertToNumberFromExcelColumnTitle {

    public static void main(String[] args) {

        String input = "AAA";

        int result = 0;

        for(int i=0;i<input.length();i++){
            char ch  = input.charAt(i);

            result*=26;
            result+= ch - 'A' +1;

        }
        System.out.println("result-> "+ result);
    }

}
