/**
 * @(#)Lab02_Q1.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/15
 */

//This program calculates different types of measurment from the user input which is written in millimeters
import java.util.Scanner;
public class Lab02_Q1 {
        
    public static void main( String[] args ) {
    	//Declaring input variable
    	double userInputMillimeters ;
    	Scanner input = new Scanner( System.in );
    	
    	//Getting user input of measurement as double because user may input a decimal number
    	System.out.print( "Enter measurement in millimeters: " );
    	userInputMillimeters = input.nextDouble();
    	
    	//Turing user input into different measurement types
    	double inputInMicrometers = userInputMillimeters * 1000;
    	double inputInCentimeters = userInputMillimeters / 10;
    	double inputInMeters = userInputMillimeters / 1000;
    	
    	//Printing out different types of calculated measurements in previous statements
    	System.out.printf( "Micrometers :%11.3f%nMillimeters :%11.3f%nCentimeters :%11.3f%nMeters:%17.3f", 
    		inputInMicrometers, userInputMillimeters, inputInCentimeters, inputInMeters );
    }
}
