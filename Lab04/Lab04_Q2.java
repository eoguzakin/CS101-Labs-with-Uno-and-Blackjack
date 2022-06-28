/**
 * @(#)Lab04_Q2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/28
 */

//This is a Java program that calculates sin(x) for the given x and amount of steps(n)
import java.util.Scanner;
public class Lab04_Q2 {
    public static void main(String[] args) {
    	Scanner input = new Scanner( System.in );
    	//Variables
    	//Declaring user input and its radian version with the integer
    	int xInput;
    	double xRadian;
    	int n;
    	//Setting factorial and factory which is a variable used for multiplication and both are resetted to 1 each repetition
    	int factory;
    	double factorial;
    	//Declaring next step and setting result to 0 as we don't have a value for it
    	double nextStep;
    	double result = 0;
    	//Setting step to 1 and using count = 1 for both power function and factorials
    	int count = 1;
    	int step = 1;
    	//Getting user input and converting it to radian
    	System.out.print( "Enter the radian(x): " );
    	xInput = input.nextInt();
    	xRadian = xInput * 2 * (3.14159265) / 360;
    	System.out.print( "Enter the integer(n): " );
    	n = input.nextInt();
    	//Entering the loop until step number is bigger than the integer
    	while( step <= n ){
    		//Setting factory and factorial both to 1 for each loop as each factorial is calculated seperately on each step
    		factorial = 1;
    		factory = 1;
    		//Calculating factorial for the current count which indicates both the factorial and the power of x
    		while( factory <= count ){
    			//Multiplying each factory to form a factorial
    			factorial = factorial * factory;
    			//Incrementing factory so that a sequence of multiplications will be formed
    			factory++;
    		}
    		//Checking whether the step number is odd or even and deciding to add or extract the next step from the result
    		if( step%2 == 1 ){
    			//As the next step is positive on odd steps we add it to result
    			nextStep = Math.pow( xRadian,count ) / factorial;
    		}
    		else{
    			//As the next step is negative on even steps we extract it from the result
    			nextStep = -1 * Math.pow( xRadian,count ) / factorial;
    		}
    		//Calculating the result for this loop
    		result = result + nextStep;
    		//Incrementing the step for the next loop
    		step++;
    		//Adding to to count as in each step, powers and factorials are odd numbers
    		count = count + 2;
    	}
    	//Displaying the results
    	System.out.println( "result is: " + result );
    }
 }