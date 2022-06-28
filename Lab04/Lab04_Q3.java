/**
 * @(#)Lab04_Q3.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/28
 */
//This is a Java program that determines if a word input by the user is a pair-word.
//A pair-word is a word where each character appears exactly two times.
import java.util.Scanner;
public class Lab04_Q3 {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Declaring two types of user input, one of them will be only lowercase for comparison
        String wordUnmodified;
        String word;
        //Declaring two chars for comparing, taken from lowercase input
        char c1;
        char c2;
        //Setting occurance of letters, times of steps, and count parameters for each character to 0
        //Declaring occurance as double to compare it presicely at the end
        double occurance = 0;
        int countC1 = 0;
        int countC2 = 1;
        int times = 0;
        //Getting and modifying user input
        System.out.print("Enter a word: ");
        wordUnmodified = input.next();
        word = wordUnmodified.toLowerCase();
        //Declaring the length variable to make a shortcut and declaring as double to compare it presicely at the end
        double length = word.length();
        //Entering the loop for character 1 which has another one inside for character 2 for comparison
        //Setting the boundary of first loop as length -1 because the index system starts at zero and ends at length-1
        while(times <= length-1){
        	//Choosing the character 1 at the index countC1 of user input
        	c1 = word.charAt(countC1);
        	//Summing countC1 and countC2 to scanning the next character after character 1
        	countC2 = countC2 + countC1;
        	//Setting the boundary of second loop as length -1 because the index system starts at zero and ends at length-1
        	while(countC2 <= length-1){
        		//Taking the next character for character 2
        		c2 = word.charAt(countC2);
        		//Checking if there are any ocurrances of similarity on every index after character 1
        		//If there is then incrementing occurance by 1
        		//If not then incrementing countC2 to continue the second loop
        		if(c1 == c2){
        			occurance++;
        		}
        		else{
        		}
        		countC2++;	
        	}
        	//Setting the countC2 to 1 for scanning only the next character after character 1 which is determined by countC1
        	//Incrementing countC1 to continue the index scanning and times to continue the loop
        	countC2 = 1;
        	countC1++;
        	times++;
        }
        //After breaking the loop checking if the occurances for each letter is 1
        if(occurance == length/2){
        	System.out.println(word + " is a pair word!");
        }
        else{
        	System.out.println(word + " is not a pair-word!");
        }
        
        }
        
}
