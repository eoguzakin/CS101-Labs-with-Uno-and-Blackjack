/**
 * @(#)Lab03_Q2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/21
 */

/*
 * This is a program that determines the age dependency category for a given country using the information below.
 * Formulas:
 * Child Dependency: number of children (age < 15) per each 100 working adults (15-64)
 * Senior Dependency: number of seniors (age > 64) per each 100 working adults (15-64).
 */
import java.util.Scanner;
public class Lab03_Q2 {
	
    public static void main(String[] args) {
        //Creating a scanner
        Scanner input = new Scanner(System.in);
        
        //Declaring needed information to calculate
        double numOfChildren;
        double numOfWorkingAdults;
        double numOfSeniors;
        double childDependency;
        double seniorDependency;
        //Getting user input
        System.out.print("Enter number citizen under 15: ");
        numOfChildren = input.nextDouble();
		System.out.print("Enter number citizen between 15 and 64: ");
		numOfWorkingAdults = input.nextDouble();
		System.out.print("Enter number citizen over 64: ");
		numOfSeniors = input.nextDouble();
		
		//Calculating Child and Senior Dependency and displaying them
        childDependency = (numOfChildren * 100 / numOfWorkingAdults);
        seniorDependency = (numOfSeniors * 100 / numOfWorkingAdults);
        System.out.printf("%nChild Dependency: %3.1f%nSenior Dependency: %3.1f%n",childDependency,seniorDependency);
        
        /**Checking those values to find a certain category
        * If Senior Dependency is less than 15;
        *	-If Child Dependency is less than 29 it is Low Overall Dependency
        *	-If Child Dependency is between and equal to 29 and 45 than it is Moderate Child Dependency
        *	-If Child Dependency is over 45 than it is High Child Dependency
        * If Senior Dependency is equal to or over 15;
        *	-If Child Dependency is over or equal to 29 than it is Double Dependency
        *	-If Child Dependency is less than 29 than it is High Old-age Dependency
        */
        
        if( seniorDependency < 15){
        	if (childDependency < 29){
        		System.out.print("Age Dependency Category: Low Overall Dependency");
        	}
        	else if((29 <= childDependency) && (childDependency <= 45)){
        		System.out.print("Age Dependency Category: Moderate Child Dependency");
        	}
        	else if(childDependency > 45){
        		System.out.print("Age Dependency Category: High Child Dependency");
        	}
        }
        else if(seniorDependency >= 15){
        	if((childDependency >= 29.0)){
        		System.out.print("Age Dependency Category: Double Dependency");
        	}
        	else if(childDependency < 29){
        		System.out.print("Age Dependency Category: High Old-age Dependency");
        	}
        }
    }
    }
