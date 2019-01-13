package org.algos.ic.lc;

import org.junit.Assert;
import org.junit.Test;

public class Palindrome {

    @Test
    public void testValidCase(){
        Assert.assertTrue(validatePalndromeString("amma"));
        Assert.assertFalse(validatePalndromeString("dad"));
    }

    private static boolean validatePalndromeString(String input) {

      char[] array =   input.toCharArray();
      int startIndex = 0;
      int endIndex = array.length-1;

      while(startIndex < endIndex){

          if(array[startIndex]!=array[endIndex])
              return false;
          startIndex++;
          endIndex--;
      }
      return true;
    }

}
