/**
 * @(#)Lab09_Q1.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/4/25
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Lab09_Q1 {
	//Scanner object
	public static Scanner input = new Scanner(System.in);
	//fillList object
	public static ArrayList<Integer> fillList(){
		//creating an empty array list
		ArrayList<Integer> array = new ArrayList<Integer>();
        System.out.println("Enter values: ");
        //filling the array list until there are no integers to add
    	while(input.hasNextInt()){
        	array.add(input.nextInt());
        }
        //clearing the last input by assigning it to a string
        String n = input.next();
        //returning the filled array
        return array;
	}
	//this is a function to sum array elements which are divisible by the user input
	public static void sumDivisible(ArrayList<Integer> original, ArrayList<Integer> sumList1, int divisor){
		int i = 0;
		int sum = 0;
		while(i < original.size()){
			int x = original.get(i);
			//if divisible we add this number to sum
			if(x % divisor == 0){
				sum = sum + x;
			}
			//at the end we add each sums to sumList
			sumList1.add(sum);
			i++;
		}
	}
	//this function removes duplicate sum elements from the sumList
	public static void removeDuplicates(ArrayList<Integer> sumList){
		int i = 0;
		while(i + 1 < sumList.size()){
			//taking the first sum
			int first = sumList.get(i);
			//taking the second sum
			int second = sumList.get(i+1);
			//comparing them, if equals then remmoving the current one
			// and NOT incrementing i to be able to continue
			if(first == second){
				sumList.remove(i);
			}
			//if not equal, then incrementing i to move to the next index
			else{
				i++;
			}
		}
	}
    public static void main(String[] args) {
    	//original user input array
    	ArrayList<Integer> original = new ArrayList<Integer>();
    	//array of sums
    	ArrayList<Integer> sumList = new ArrayList<Integer>();
    	//filling original array
    	original = fillList();
    	System.out.print("Enter divisor: ");
    	int divisor = input.nextInt();
    	System.out.println("List: " + original);
    	//summing divisible numbers
        sumDivisible(original,sumList,divisor);
        System.out.println("Sum List: " + sumList);
        //removing duplicates
        removeDuplicates(sumList);
        System.out.println("Sum List (no duplicates): " + sumList);
    }
}
