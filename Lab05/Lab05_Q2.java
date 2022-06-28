/**
 * @(#)Lab05_Q2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/3/7
 */

/*
 *This is a program that inputs a nucleic acid sequence and displays its encoded form.
 */
import java.util.Scanner;
public class Lab05_Q2 {
    public static void main( String[] args ) {
        Scanner input = new Scanner( System.in );
        //Declaring user input
        String userGene;
        //Declaring gene types and a comparison character
        char A = 'A';
        char T = 'T';
        char C = 'C';
        char G = 'G';
        char check;
        //Setting the occurences in DNA for each gene to 0
        int ATimes = 0;
        int TTimes = 0;
        int CTimes = 0;
        int GTimes = 0;
        //Getting user info
        System.out.print( "Enter a nucleic acid sequence: " );
        userGene = input.next();
        //Checking and incrementing gene counts each time when an occurence appears
        for( int count = 0; count <= userGene.length() - 1; count++ ){
        	check = userGene.charAt(count);
        	if( check == A ){
        		ATimes++;
        	}
        	else if( check == T ){
        		TTimes++;
        	}
        	else if( check == C ){
        		CTimes++;
        	}
        	else if( check == G ){
        		GTimes++;
        	}
        }
        //Printing the results
        System.out.printf( "Encoded Sequence: %c%d%c%d%c%d%c%d", A, ATimes, T, TTimes, C, CTimes, G, GTimes );
    }
}
