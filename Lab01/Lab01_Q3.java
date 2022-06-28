/**
 * @(#)Lab01_Q3.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 
 * @date   2021/2/8
 * Edited in 2021/2/9
 */


public class Lab01_Q3 
{
	public static void main( String args[]) 
    {
    	/* 
    	 *These information is given for the following questions;
    	 *The total area of the world is 510072000km2. 
    	 *29.2% of this area is dry land and the rest is covered by water. 
    	 *The total area of Turkey is 783562km2. 
    	 *1.3% percent of Turkey is sea.
    	 *Questions;
    	 *1. How much of the area of the world is dry land and how much is water?
		 *2. How much of the area in Turkey is dry land and how much is water?
		 *3. What percent of the whole dry land of earth is in Turkey?
		 *4. What percent of all water is in Turkey?
    	 */
    	 	//Constants
    	 	final long TOTAL_AREA_WORLD = 510072000;
    	 	final long TOTAL_AREA_TURKEY = 783562;
    	 	final double DRY_LAND_PERCENTAGE_WORLD = 29.2 /100;
    	 	final double SEA_PERCENTAGE_TURKEY = 1.3 / 100;
    	 	final long DRY_LAND_AZERBAIJAN = 500000;

    	 	//Variables
    	 	double dryLandWorld;
    	 	double waterCoveredAreaWorld;
    	 	double waterCoveredAreaTurkey;
    	 	double dryLandTurkey;
    	 	double turkeyPercentageWholeDryLand;
    	 	double turkeyPercentageAllWater;
    	 	double percentageAzerbaijanTurkeyWorldDryArea;
    	 	/*We first calculate the dry land area on Earth so that we can find the water area by extracting the dry land of Earth.
    	 	*To do that we multiply total world area with the dry land percentage.
    	 	*Then we calculate the water area of Turkey by multiplying the total area of Turkey with the water area percentage.
    	 	*Then by extracting the water area of Turkey we find dry land area of Turkey.
    	 	*We then calculate the Turkey's dry land percentage and water percentage of the Earth's.
    	 	*/
    	 	dryLandWorld = TOTAL_AREA_WORLD * DRY_LAND_PERCENTAGE_WORLD;
    	 	waterCoveredAreaWorld = TOTAL_AREA_WORLD - dryLandWorld;
    	 	waterCoveredAreaTurkey = TOTAL_AREA_TURKEY * SEA_PERCENTAGE_TURKEY;
    	 	dryLandTurkey = TOTAL_AREA_TURKEY - waterCoveredAreaTurkey;
    	 	turkeyPercentageWholeDryLand = dryLandTurkey / dryLandWorld * 100;
    	 	turkeyPercentageAllWater = waterCoveredAreaTurkey / waterCoveredAreaWorld * 100;
    	 	percentageAzerbaijanTurkeyWorldDryArea = (dryLandTurkey + DRY_LAND_AZERBAIJAN) / dryLandWorld * 100;
    	 	/*
    	 	 *As now we have the needed answers, we print out both questions and answers.
    	 	 */
    	 	 //Questions and Answers
    	 	System.out.println( "1. How much of the area of the world is dry land and how much is water?" );
    	    System.out.println( "Earth has " + Math.round(dryLandWorld) + " km2 dry land and " + Math.round(waterCoveredAreaWorld) + " km2 water." );
    	    System.out.println( "2. How much of the area in Turkey is dry land and how much is water?" );
    	    System.out.println( "Turkey has " + Math.round(dryLandTurkey) + " km2 dry land and " + Math.round(waterCoveredAreaTurkey) + " km2 water." );
    	    System.out.println( "3. What percent of the whole dry land of earth is in Turkey?" );
    	    System.out.println( "Turkey has " + turkeyPercentageWholeDryLand + " percent of the Earth's dry land." );
    	    System.out.println( "4. What percent of all water is in Turkey?" );
    	    System.out.println( "Turkey has " + turkeyPercentageAllWater + " percent of the Earth's water." );
    	    System.out.printf( "Turkey's and Azerbaijan's dry land percentage compared to the Earth is: " + percentageAzerbaijanTurkeyWorldDryArea);
    }
    
    
}