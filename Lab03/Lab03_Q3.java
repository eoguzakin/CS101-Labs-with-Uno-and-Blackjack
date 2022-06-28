/**
 * @(#)Lab03_Q3.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/21
 */

/*
 * This is a Java program that inputs a string and an integer value, n, from the user.
 * This program output an appropriate message if the first and last n characters of the string are the same (case and order).
 * If the last character of the string is punctuation (assume non-alphabetic), the last n characters compared should aren't included ina the period
 */

import java.util.Scanner;
public class Lab03_Q3 {
	
    public static void main(String[] args) {
        //Creating a scanner
        Scanner input = new Scanner(System.in);
        
        //Declaring user input which haven't recieved any changes by the program
        String userInputSentenceUnmodified;
        int userInputInt;
        
        //Boundaries of possible user integer input
        int setNum1 = 1;
        int setNum2 = 8;
        
        //Getting user input
        System.out.print("Enter a sentence: ");
        userInputSentenceUnmodified = input.nextLine();
        System.out.print("Enter an integer value between " + setNum1 + " and " + setNum2 + ": ");
        
        /**Checking if the number user inputs is an integer
         * If not then displaying an error message
         */
        
        if(input.hasNextInt()){
        	userInputInt = input.nextInt();
       	    
       	    /**
        	 * Checking if the number user inputs is in the set boundary
        	 * If not then displaying an error message
        	 * Checking if the first and last parts of user sentence input are the same
        	 * Displaying the results
        	 */
        	
        	if(setNum1 <= userInputInt && userInputInt <= setNum2){
        		//Changing user input according to conditions and clearing all non-alphabetic characters and integers in sentence string
        		String userInputSentence = userInputSentenceUnmodified.replaceAll("[^A-Za-z]+", "");
        		String first = userInputSentence.substring(0,userInputInt);
        		String last = userInputSentence.substring(userInputSentence.length() - userInputInt);
        		
        		//If equality in string achieved according to the condition then print this sentence, else display other sentence
        		if( first.equals(last) ){
        			System.out.println("First and last " + userInputInt + " characters are the same");
        			}
        		else{
        			System.out.println("First and last " + userInputInt + " characters are not the same");
        			}
        		}
        	else{
        	System.out.printf("Error - value must be between %d and %d",setNum1,setNum2);
        		}
			}
		else{
        	System.out.println("Error - value must be an integer");
        	}
		}
	}