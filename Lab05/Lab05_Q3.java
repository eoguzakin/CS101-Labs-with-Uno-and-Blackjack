/**
 * @(#)Lab05_Q3.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/3/7
 */

/*
 *This is a program that inputs a minimum and maximum number of people
 *and displays the probabilities where r = min_value through max_value and d represents the number of days in the year assume it is 365.
 *The program also validates that minimum value is less than the maximum value using a do-while loop.
 */
import java.util.Scanner;
public class Lab05_Q3 {
    public static void main( String[] args ) {
        Scanner input = new Scanner( System.in );
        //Declaring an empty string to print the table correctly
        String s = "";
        //Year
        int d = 365;
       	//Parameters for do-while loops
       	int a = 0;
        int i = 0;
        //Max and min number of people
        int maxNum;
        int minNum;
        //Result of calculations
        double sameBirthday;
        double extraction = 1;
        //Getting user info and checking if max is bigger than min, if not asking again
        do{
        System.out.print( "Enter the minimum and maximum number of people: " );
        minNum = input.nextInt();
        maxNum = input.nextInt();
        if(maxNum <= minNum){
        	System.out.println("Invalid input - minimum must be less than maximum...");
        }
        }while(maxNum <= minNum);
        	//Starting to print out the table
        	System.out.printf( "NUMBER OF PEOPLE%8sPROBABILITY%n", s );
        	//Calculating probabilities for each number of people
        	do{
        		//Calculating the extraction from 1
        		do{
        		extraction = ( ( d - i ) * extraction ) / d;
        		i++;
        		}while( i <= minNum - 1 );
        	sameBirthday = 1 - extraction;
        	//Printing the rest of the table
        	System.out.printf( "%d%f%n", minNum + a, sameBirthday );
        	a++;
        	}while( a + minNum <= maxNum );
    }
}
