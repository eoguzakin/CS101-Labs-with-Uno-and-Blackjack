/**
 * @(#)Lab03_Q1.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/21
 */

/**
 * This is a Java program that calculates and displays the rounded sum of 2 values input by the user, according to the following;
 * 1) An int value is rounded up to the next multiple of 10 if its right-most digit is 5 or more.
 * 2) If the right-most digit is less than 5 it is rounded down to the previous multiple of 10.
 * 3) If the first rounded value is a multiple of 3, the second value will not be rounded before adding to the sum.
 */

import java.util.Scanner;
public class Lab03_Q1 {
	
    public static void main(String[] args) {
        //Creating scanner object
        Scanner input = new Scanner(System.in);
        
        //Declaring user input and other variables
        int val1;
        int val2;
        int modulusVal1;
        int modulusVal2;
        int roundedVal1;
        int roundedVal2;
        int sumOfVal2RoundedVal1;
        int sumOfRoundedBoth;
        
        //Getting user input
        System.out.print("Enter 2 numbers: ");
        val1 = input.nextInt();
        val2 = input.nextInt();
        
        //Calculating moduluses of input to use in rounding calculations
        modulusVal1 = val1 % 10;
        modulusVal2 = val2 % 10;
        
        //Rounding value 1 and rounding value 2 if modulus 1 is equal or bigger than 5
        //If true continuing
        //If false skipping to else statement
        if(modulusVal1 >= 5){
        	roundedVal1 = val1 - modulusVal1 + 10;
            //Rounding value 2 if modulus 2 is equal or greater that 5 and so, continuing to check if value 1 is a multiple of 3
        	if(modulusVal2 >= 5){
        	roundedVal2 = val2 - modulusVal2 + 10;
        	//Checking if value 1 is a multiple of 3 and then printing our solution according to necessary conditions
        	//If true, then we don't round value 2 and sum rounded value 1 and value 2 directly
        	//If false, then we round both numbers and sum them
        	if( (roundedVal1%3) == 0 ){
        	sumOfVal2RoundedVal1 = roundedVal1 + val2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfVal2RoundedVal1);
        	}
        	else{
        	sumOfRoundedBoth = roundedVal1 + roundedVal2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfRoundedBoth);
        	}
        	
        	}
        	else if(modulusVal2 < 5){
        	roundedVal2 = val2 - modulusVal2;
        	//Checking if value 1 is a multiple of 3 and then printing our solution according to necessary conditions
        	//If true, then we don't round value 2 and sum rounded value 1 and value 2 directly
        	//If false, then we round both numbers and sum them
        	if( (roundedVal1%3) == 0 ){
        	sumOfVal2RoundedVal1 = roundedVal1 + val2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfVal2RoundedVal1);
        	}
        	else{
        	sumOfRoundedBoth = roundedVal1 + roundedVal2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfRoundedBoth);
        	}
        	
        	}
        	
        }
        //Checking if modulus value 1 is lesser then 5
        else if(modulusVal1 < 5){
        	roundedVal1 = val1 - modulusVal1;
            
        //Rounding value 2
        if(modulusVal2 >= 5){
        	roundedVal2 = val2 - modulusVal2 + 10;
        	
        	//Checking if value 1 is a multiple of 3 and then printing our solution according to necessary conditions
        	if( (roundedVal1%3) == 0 ){
        	sumOfVal2RoundedVal1 = roundedVal1 + val2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfVal2RoundedVal1);
        	}
        	else{
        	sumOfRoundedBoth = roundedVal1 + roundedVal2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfRoundedBoth);
        	}
        	
        	}
        else if(modulusVal2 < 5){
        	roundedVal2 = val2 - modulusVal2;
        	//Checking if value 1 is a multiple of 3 and then printing our solution according to necessary conditions
        	//If true, then we don't round value 2 and sum rounded value 1 and value 2 directly
        	//If false, then we round both numbers and sum them
        	if( (roundedVal1%3) == 0 ){
        	sumOfVal2RoundedVal1 = roundedVal1 + val2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfVal2RoundedVal1);
        	}
        	else{
        	sumOfRoundedBoth = roundedVal1 + roundedVal2;
        	System.out.printf("The sum of the rounded values of %d and %d: %d%n", val1, val2, sumOfRoundedBoth);
        	}
        	
        	}
        		
        }
     } 
  }
