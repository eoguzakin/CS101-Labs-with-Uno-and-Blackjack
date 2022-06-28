/**
 * @(#)Lab02_Q2.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/2/15
 */

//This program calculates your expenses and remaining money according to your salary
import java.util.Scanner;
public class Lab02_Q2 {
	
    public static void main( String[] args ) {
        //Constants including, framework of the table and names with percentages of expenses
        final char percentage = '%';
        final String tableFrame = "---------------------------------------------";
        final String housing = "Housing";
        final String food = "Food";
        final String transport = "Transport";
        final String savings = "Savings";
        final String total = "TOTAL";
        final String remaining = "REMAINING";
        final int housingPercentage = 30;
        final int foodPercentage = 15;
        final int transportPercentage = 20;
        final int savingsPercentage = 18;
        
        //Getting user salary to calculate expenses and remaining money
        int userMonthlySalary ;
        Scanner input = new Scanner( System.in );
        System.out.print( "Enter monthly salary: " );
        userMonthlySalary = input.nextInt();
        
        //Calculating monthly expenses and remaining money from the monthly salary using constant percentages
        double housingExpenses = userMonthlySalary * housingPercentage / 100;
        double foodExpenses = userMonthlySalary * foodPercentage / 100;
        double transportExpenses = userMonthlySalary * transportPercentage / 100;
        double savingsExpenses = userMonthlySalary * savingsPercentage / 100;
        double totalExpenses = housingExpenses + foodExpenses + transportExpenses + savingsExpenses;
        double remainingMoney = userMonthlySalary - totalExpenses;
        
        //Printing out the table and the variables in it
        System.out.printf( "%s%n|%s%15c%d%18.2f |%n|%s%18c%d%18.2f |%n", tableFrame, housing, percentage, housingPercentage, housingExpenses, food,percentage, foodPercentage, foodExpenses );
        System.out.printf( "|%s%13c%d%18.2f |%n|%s%15c%d%18.2f |%n", transport, percentage, transportPercentage, transportExpenses, savings, percentage, savingsPercentage, savingsExpenses );
        System.out.printf( "|%26s%16.2f |%n|%30s%12.2f |%n%s", total, totalExpenses, remaining, remainingMoney, tableFrame );
    }
}
