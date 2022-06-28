/**
 * @(#)Lab01_Q2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 
 * @date   2021/2/8
 * Edited in 2021/2/9
 */


public class Lab01_Q2 
{

    public static void main( String args[]) 
    {
    	/*
    	 *Questions:
    	 *x = (23.2 - 7.1 / 2.2) / ((5.1 - 3.7) * (3.4 + 4.2)) , x=?
    	 *y = (35.7 * 64.1 - (6.0^3)) / (43 + (5^2)) , y=?
    	 *z = ((2.1 + 8.0)^(-3^-1)) , z=? 
    	 */
    	//Variables
    	double newVar;
    	newVar = Math.pow(5,2) * Math.pow(4,8) / Math.pow(9,5);
    	double answer1;
    	answer1 = (23.2 - 7.1 / 2.2) / ((5.1 - 3.7) * (3.4 + 4.2));
    	double answer2;
    	answer2 = (35.7 * 64.1 - Math.pow ( 6.0,3 )) / (43 + Math.pow( 5,2 ));	
    	double answer3;
    	answer3 = Math.pow( (2.1 + 8.0),(Math.pow( -3,-1 )) );
    		System.out.println( "Answer1 is: " + answer1 );
    		System.out.println( "Answer2 is: " + answer2 );
    		System.out.println( "Answer3 is: " + answer3 );
    		System.out.printf( "Answer4 is: %f", newVar);
    }
    
    
}