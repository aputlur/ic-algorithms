package org.algos.ic.puzzlers;
import java.util.Scanner;

public class PrintBits
{
    public static void main( String args[] )
    {
        // get input integer
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Please enter an integer:" );
        int input = scanner.nextInt();

        // display bit representation of an integer
        System.out.println( "\nThe integer in bits is:" );

        // create int value with 1 in leftmost bit and 0s elsewhere
        int displayMask = 1 << 31;
        System.out.println("displayMask -> "+ displayMask);

        // for each bit display 0 or 1
        for ( int bit = 1; bit <= 32; bit++ )
        {
            // use displayMask to isolate bit
            System.out.print( ( input & displayMask ) == 0 ? '0' : '1' );

            input <<= 1; // shift value one position to left

            if ( bit % 8 == 0 )
                System.out.print( ' ' ); // display space every 8 bits
        } // end for
    } // end main
} // end class PrintBits

