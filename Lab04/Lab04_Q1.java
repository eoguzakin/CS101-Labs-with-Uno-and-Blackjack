/**
 * @(#)Lab04_Q1.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/28
 */
/*
 *This is a program that inputs the type of ball and the initial height and calculates 
 *and displays how many times the ball will bounce when dropped from its initial height before it rises to a height of less than 10 centimeters.
 *It also displays the total distance travelled by the ball before this point.
 */
import java.util.Scanner;
public class Lab04_Q1 {

    public static void main( String[] args ) {
        //Declaring Scanner object
        Scanner input = new Scanner( System.in );
        //Declaring user input variables, travel measurements and heights of each bounces
        String ballType;
        int initialHeightMeters;
        int initialHeightCentimeters;
        double nextBounceHeight;
        double travelTotalMeters;
        double travelCentimeters;
        //Declaring ball bounce coefficiencies
        final double coefficiencyTennis = 0.7;
        final double coefficiencyBasket = 0.75;
        final double coefficiencySuper = 0.9;
        final double coefficiencySoft = 0.3;
        //Setting bouncing number as one because the ball is thrown at least from 100cm and it will certainly bounce once
        int bounceNum;
        bounceNum = 1;
        //Getting user input of ball type
        System.out.print( "Enter Ball Type: " );
        ballType = input.nextLine();
        //If the input type isn't valid showing error to user, if valid then deciding which type it is
        if( ballType.equals( "Tennis Ball" ) ){
        	//Checking if height is an integer, if not showing error
        	System.out.print( "Enter initial height(m): " );
        	while( !input.hasNextInt() ){
        	System.out.println( "Height must be numeric value..." );
        	System.out.print( "Enter initial height(m): " );
        	input.nextInt();
        	}
        	//Calculating next bouncing height according to coefficiency and transforming measurement types to centimeters
        	initialHeightMeters = input.nextInt();
        	initialHeightCentimeters = initialHeightMeters * 100;
        	travelCentimeters = 0;
        	nextBounceHeight = initialHeightCentimeters * coefficiencyTennis;
        		//As log as the last height is bigger than 10cm, adding one to bounce number and adding all the distances covered
        		while( nextBounceHeight >= 10 ){
        			bounceNum++;
        			travelCentimeters = travelCentimeters + ( nextBounceHeight * 2 );
        			nextBounceHeight = nextBounceHeight * coefficiencyTennis;
        		}
        	//Transforming the sum of distances to meters and adding the initial heigth to calculate total covered distance
        	travelTotalMeters = ( travelCentimeters) / 100 + initialHeightMeters ;
        	//Showing results
        	System.out.println( "Number of Bounces: " + bounceNum );
        	System.out.printf( "Meters Travelled: %.2f", travelTotalMeters );
        }
        else if( ballType.equals( "Basketball" ) ){
        	//Checking if height is an integer, if not showing error
        	System.out.print( "Enter initial height(m): " );
        	while( !input.hasNextInt() ){
        	System.out.println( "Height must be numeric value..." );
        	System.out.print( "Enter initial height(m): " );
			input.nextLine();
        	}
        	//Calculating next bouncing height according to coefficiency and transforming measurement types to centimeters
        	initialHeightMeters = input.nextInt();
        	initialHeightCentimeters = initialHeightMeters * 100;
        	travelCentimeters = 0;
        	nextBounceHeight = initialHeightCentimeters * coefficiencyBasket;
        		//As log as the last height is bigger than 10cm, adding one to bounce number and adding all the distances covered
        		while( nextBounceHeight >= 10 ){
        			bounceNum++;
        			travelCentimeters = travelCentimeters + ( nextBounceHeight * 2 );
        			nextBounceHeight = nextBounceHeight * coefficiencyBasket;
        		}
        	//Transforming the sum of distances to meters and adding the initial heigth to calculate total covered distance
        	travelTotalMeters = ( travelCentimeters) / 100 + initialHeightMeters ;
        	//Showing results
        	System.out.println( "Number of Bounces: " + bounceNum );
        	System.out.printf( "Meters Travelled: %.2f", travelTotalMeters );
        }
        else if( ballType.equals( "Superball" ) ){
        	//Checking if height is an integer, if not showing error
        	System.out.print( "Enter initial height(m): " );
        	while( !input.hasNextInt() ){
        	System.out.println( "Height must be numeric value..." );
        	System.out.print( "Enter initial height(m): " );
			input.nextLine();
        	}
        	//Calculating next bouncing height according to coefficiency and transforming measurement types to centimeters
        	initialHeightMeters = input.nextInt();
        	initialHeightCentimeters = initialHeightMeters * 100;
        	travelCentimeters = 0;
        	nextBounceHeight = initialHeightCentimeters * coefficiencySuper;
        		//As log as the last height is bigger than 10cm, adding one to bounce number and adding all the distances covered
        		while( nextBounceHeight >= 10 ){
        			bounceNum++;
        			travelCentimeters = travelCentimeters + ( nextBounceHeight * 2 );
        			nextBounceHeight = nextBounceHeight * coefficiencySuper;
        		}
        	//Transforming the sum of distances to meters and adding the initial heigth to calculate total covered distance
        	travelTotalMeters = ( travelCentimeters) / 100 + initialHeightMeters ;
        	//Showing results
        	System.out.println( "Number of Bounces: " + bounceNum );
        	System.out.printf( "Meters Travelled: %.2f", travelTotalMeters );
        }
        else if( ballType.equals( "Softball" ) ){
        	//Checking if height is an integer, if not showing error
        	System.out.print( "Enter initial height(m): " );
        	while( !input.hasNextInt() ){
        	System.out.println( "Height must be numeric value..." );
        	System.out.print( "Enter initial height(m): " );
        	input.nextLine();
        	}
        	//Calculating next bouncing height according to coefficiency and transforming measurement types to centimeters
        	initialHeightMeters = input.nextInt();
        	initialHeightCentimeters = initialHeightMeters * 100;
        	travelCentimeters = 0;
        	nextBounceHeight = initialHeightCentimeters * coefficiencySoft;
        		//As long as the last height is bigger than 10cm, adding one to bounce number and adding all the distances covered
        		while( nextBounceHeight >= 10 ){
        			bounceNum++;
        			travelCentimeters = travelCentimeters + ( nextBounceHeight * 2 );
        			nextBounceHeight = nextBounceHeight * coefficiencySoft;
        		}
        	//Transforming the sum of distances to meters and adding the initial heigth to calculate total covered distance
        	travelTotalMeters = ( travelCentimeters) / 100 + initialHeightMeters ;
        	//Showing results
        	System.out.println( "Number of Bounces: " + bounceNum );
        	System.out.printf( "Meters Travelled: %.2f", travelTotalMeters );
        }
        else{
        	System.out.print("Invalid Ball Type - Exiting...");
        }
    }
}
