/**
 * @(#)Lab05_Q1_B.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/3/11
 */

/*
 *Q1B. is a program that isplays each three-digit narcissistic number and their sum.
 *A narcissistic number is a number that is equal to the sum of its digits each raised to the power of the number of digits.
 */

import java.util.Scanner;
public class Lab05_Q1_B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Variables
        String userNum;
        String substring;
        int countB;
        int digit;
        int digitCheck;
        //We set the result to 0 as there aren't any numbers input
        int result = 0;
        //We will execute these statements if user doesn't input 0
        do{
        //Setting sum2 to 0 for every time to make comparison with the original number
        int sum2 = 0;
        //Getting the user number
        System.out.print( "Enter 3 digit number(0 to exit): " );
        userNum = input.next();
        //Checking if user inputs 0
        if(!userNum.equals( "0" )){
        	//We convert user string to integer
        	digitCheck = Integer.parseInt( userNum );
        	//For every index, we will power every digit to 3 and sum them
        	for( countB = 0; countB <= userNum.length() - 1; countB++ ){
        		substring = userNum.substring( countB, countB+1 );
        		digit = Integer.parseInt( substring );
        		sum2 = sum2 + (int)Math.pow( digit, 3 );
        	}
        	//If the user input is a narcissistic number we sum it with the others
        	//If not, we move on
        	if( sum2 == digitCheck ){
        		System.out.println( userNum + " is a narcssistic number" );
        		result = result + sum2;
        	}
        }
        else{
        	System.out.println( "Sum of three-digit narcissistic numbers: " + result );
        }
      }while( !userNum.equals( "0" ) );
    }
}
