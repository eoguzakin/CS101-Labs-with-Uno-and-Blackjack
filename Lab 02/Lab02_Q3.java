/**
 * @(#)Lab02_Q3.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/15
 */

//This program shows the date and time that it gets from your input
import java.util.Scanner;
public class Lab02_Q3 {
	
    public static void main( String[] args ) {
       Scanner input = new Scanner( System.in );
       //Setting everything other than date characters and integers as delimiters to get the information accurately
       input.useDelimiter( "[^A-Za-z0-9]+" );
       
       //Variables
       String day;
       String month;
       int year;
       int dayInMonth;
       //Here we store the hour variable as String because we want to see the output exactly as we type
       String hour;
       int minutes;
       
       //Getting user input
       System.out.print( "Enter date and time: " );
       year = input.nextInt();
       month = input.next();
       dayInMonth = input.nextInt();
       day = input.next();
       hour = input.next();
       minutes = input.nextInt();
       
       //Printing out date and time
       System.out.printf( "%s %s %d,%d %d minutes past %s", day, month, dayInMonth, year, minutes, hour );
    }
}
