/**
 * @(#)Lab02_Q3v2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/16
 */

import java.util.Scanner;
public class Lab02_Q3v2 {

    public static void main( String[] args ) {
        Scanner input = new Scanner( System.in );
        
        //Variables
        String day;
        String month;
        String year;
        String dayInMonth;
        String hour;
        String minutes;
        
        //Getting user input as date and time
        String userInput;
        System.out.print( "Enter date and time: " );
        userInput = input.nextLine();
        
        //Extracting information from the input
        year = userInput.substring( 0 , 4 );
        month = userInput.substring( 5 , 8 );
        dayInMonth = userInput.substring( 9 , 11 );
        day = userInput.substring( 12 , (userInput.length() - 6) );
        hour = userInput.substring( (userInput.length() - 5) , (userInput.length() - 3) );
        minutes = userInput.substring( (userInput.length() - 2) , userInput.length() );
        
        //Printing out information respectively
        System.out.printf( "%s %s %s,%s %s minutes past %s", day, month, dayInMonth, year, minutes, hour );
        
    }
}
