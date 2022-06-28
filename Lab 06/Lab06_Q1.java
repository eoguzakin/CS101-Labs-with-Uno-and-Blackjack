/**
 * @(#)Lab06_Q1.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/3/13
 */

/*This is a Java program that both validates and creates a valid credit card number
 *according to the Luhn Formula:
 *Drop the last digit from the number. The last digit is what we want to check against
 *Reverse the numbers
 *Multiply the digits in odd positions (1, 3, 5, etc.) by 2 and subtract 9 to all any result higher than 9
 *Add all the numbers together
 *The check digit (the last number of the card) is the amount that you would need to add to get a multiple of 10 (Modulo 10
 */
 
import java.util.Scanner;
public class Lab06_Q1 {
		
		//We get the user number here
		public static long userNum(){
    		Scanner input = new Scanner(System.in);
    		System.out.print("Enter your credit card number to validate: ");
        	return input.nextLong();
    	}
    	//We calculate how many digits does it contain
    	public static int countDigits(long cardNum){
    		//We declare two local variables to use
    		int x;
        	//We declare y = cardNum because we don't want cardNum to be modified along the way
        	long y = cardNum; 
        	//We set x = 1 and while our y number has at least two digits we divide it to 10 with integer division
        	//And increment x to measure the digit number
        	for(x = 1; y >= 9; x++){
        		y = y / 10;
        	}
        	return x;
    	}
    	//We reverse the modified card number here
    	public static long reverseNumber(long cardNumModified, int digitNum){
    		//We set the reversedNum number to 0
    		long reversedNum = 0;
    		//We can now modify the cardNumModified as we won't need it anymore
    		//While cardNumModified is not 0, we take its modulus and add it to reversed * 10 for reversing every digit
    		//Then we set cardNumModified to its integer divison to 10 for every step to move index
    		while(cardNumModified != 0) {
      			long digit = cardNumModified % 10;
       			reversedNum = reversedNum * 10 + digit;
        		cardNumModified /= 10;
    		}
    		return reversedNum;
    	}
    	//We sum the reversed numbers digits here
    	public static long sumDigits(long reversed, int digitNum){
    	long num = reversed;
    	//We set our sum to 0
    	long sum = 0;
    	//We declare a digit variable called k
    	long k;
		//For reverseNumber > 0, we divide our num to 10 and take the last digit of it
		//Then we check which index does this digit have
		//According to the Luhn Formula:
		//If index is odd, we multiply it with 2 and if the number becomes more than 9, we extract 9
		//If the index is even, we add the number to the sum straight
		for(int a = 1; num > 0; a++) {
  		long d = num / 10;
  		k = num - d * 10;
  		num = d;
  		if(digitNum % 2 == 0){
    		//Index check
    		if(a % 2 == 1){
    			k = k * 2;
    			if(k <= 9){
    				sum = sum + k;
    			}
    			else{
    				sum = sum + k - 9;
    			}
    		}
    		else{
    			sum = sum + k;
    		}
    	}
    	else{
    		//Index check
    		if(a % 2 == 0){
    			k = k * 2;
    			if(k <= 9){
    				sum = sum + k;
    			}
    			else{
    				sum = sum + k - 9;
    			}
    		}
    		else{
    			sum = sum + k;
    		}
    	}
		}
		return sum;
    	}
    	//We check the validty bu adding the last digit to sumOfReverse and taking their modulus of 10
    	//If modulus = 0, valid
    	public static boolean isValidCard(long sumOfReverse , long lastDigit){
    		if((sumOfReverse + lastDigit) % 10 == 0){
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    	//We generate our random 15-16 digit number here
    	public static long generateValidCard(){
    		//Here, as we aren't allowed to use Math.pow(), we seperate 10^14 into two smaller integers
    		//We take 10^14 out of the parantheses and extraxct 1 from 100 and multiply it to 10^5
    		return( 10000000 * 10000000 * (1000000 + (long) (Math.random() * (9900000))));
    		
    	}
    	//We display our menu here
    	public static int displayMenu(){
    		Scanner input = new Scanner(System.in);
    		int num;
    		System.out.println("---------------MENU---------------");
    		System.out.printf("1 - Validate Credit Card Number%n2 - Generate Valid Credit Card Number%n3 - Exit%n");
    		//We validate user choice while it isn't equal to 1,2 and 3
    		do{
    		System.out.print("Enter choice: ");
    		num = input.nextInt();
    		if(num != 1 && num != 2 && num !=3 ){
    			System.out.println("Invalid choice - try again");
    		}
    		}while( 0 >= num || num >= 4);
    		return num;
    	}
   
   public static void main(String[] args) {
   		//Variables
   		int choice;
   		long cardNum;
   		long lastDigit;
   		long cardNumModified;
   		int digitNum;
   		long reversed;
   		long sumOfReverse;
   		boolean validity;
   		do{
   		//We display the menu and ask the user to make a choice
   		choice = displayMenu();
   		//If we choose 1, we enter validitation of number
   		if(choice == 1){
   		//Getting user number
   		cardNum = userNum();
        //Finding last digit
        lastDigit = cardNum % 10;
        //Modifying user number for Luhn algorithm by extracting the last digit
        cardNumModified = (cardNum - lastDigit) / 10;
        //Finding how many digits the number has for Luhn Algorithm
        digitNum = countDigits(cardNum);
        //Reversing the modified number for algorithm
        reversed = reverseNumber(cardNumModified, digitNum);
        //Applying Luhn Formula and getting the sum
        sumOfReverse = sumDigits(reversed, digitNum);
        //We now check if the card number is valid
        validity = isValidCard(sumOfReverse , lastDigit);
        System.out.println("Card number is valid: " + validity + "\n");
   		}
   		//Here we generate a sample credit card number
   		if(choice == 2){
   		//We generate different numbers until the validity of our number becomes true and we display it afterwards
   		do{
   		//Generating a random card number for 15-16 digits
        cardNum = generateValidCard();
        //Finding last digit
        lastDigit = cardNum % 10;
        //Modifying user number for Luhn algorithm by extracting the last digit
        cardNumModified = (cardNum - lastDigit) / 10;
        //Finding how many digits the number has for Luhn Algorithm
        digitNum = countDigits(cardNum);
        //Reversing the modified number for algorithm
        reversed = reverseNumber(cardNumModified, digitNum);
        //Applying Luhn Formula and getting the sum
        sumOfReverse = sumDigits(reversed, digitNum);
        //We now check if the card number is valid and we implement all these steps again until we get a number which is valid
        validity = isValidCard(sumOfReverse , lastDigit);
   		}while(validity != true);
   		System.out.println("Sample valid credit card: " + cardNum + "\n");
   		}
   	    }while(choice != 3);
   	    //If we choose 3, the program terminates
   		if(choice == 3){
   		System.out.println("Goodbye!");
   		}
   }
}