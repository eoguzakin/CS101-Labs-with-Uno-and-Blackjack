/**
 * @(#)Lab05_Q1.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/3/7
 */

/*
 *Q1A. is a program that inputs a string and sums all digits in the string.
 */
import java.util.Scanner;
public class Lab05_Q1_A {
    public static void main( String[] args ) {
        Scanner input = new Scanner( System.in );
        //Q1.A
        //Variables for question 1.a, we set sum to 0 as there is nothing to read now
        String userInput;
        String userInputModified;
        int sum = 0;
        int digitPow3;
        char check;
        //Getting user input sentence for question 1.a
        System.out.print( "Enter a sentence: " );
        userInput = input.nextLine();
        //Getting rid of all non numeric values inside the input and storing it as String for extracting every number
        userInputModified = userInput.replaceAll( "[^0-9]+", "" );
        //Checking if input contains numbers, if not showing error
        if( !userInputModified.equals( "" ) ){
        //For all indexes of modified user input, we take each number as character and then turn it to string and then to integer
        //After this we add the number to sum and repeat the loop until conditions are achieved
        for( int count = 0; count <= userInputModified.length() - 1; count++ ){
        	check = userInputModified.charAt( count );
        	digitPow3 = Character.getNumericValue( check ) ;
        	sum = sum + digitPow3;
        }
        System.out.println( sum );
        }
        else{
        System.out.println( "No numeric characters exist in the input string" );
        }
    } 
}
