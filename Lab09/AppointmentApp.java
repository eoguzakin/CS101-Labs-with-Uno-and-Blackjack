/**
 * @(#)AppointmentApp.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/4/25
 */
import java.util.ArrayList;
import java.util.Scanner;
public class AppointmentApp {
	//Array sorting method
	public static void sortAppointments(ArrayList<Time> schedule){
		//We check each time objects that come after each other
		//if we find an object who is less than the current one we replace it to current position
		//by removing and adding, and assign current object to second one to keep looking
		//else we continue to check others
		for(int a = 0; a < schedule.size(); a++){
			Time t1 = schedule.get(a);
			for(int b = a + 1; b < schedule.size(); b++){
				Time t2 = schedule.get(b);
				if(t1.lessThan(t2)){
					continue;
				}
				else{
					schedule.add(a, schedule.remove(b));
					t1 = schedule.get(a);
				}
			}
		}
	}
	//Appointment printer using enhanced for loop
	public static void printAppointments(ArrayList<Time> schedule){
		for(Time t : schedule){
			System.out.println(t.toString());
		}
	}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //setting delimiter to : and new line character
        input.useDelimiter(":|\\n");
        //creating a schedule array
        ArrayList<Time> schedule = new ArrayList<Time>();
        //taking user input to fill the array for 7 times
        for(int a = 1; a < 8; a++){
        	System.out.print("Enter appointment time: ");
        	int hour = input.nextInt();
        	int minute = input.nextInt();
        	Time t = new Time(hour, minute);
        	schedule.add(t);
        }
        //printing appointments
        System.out.println("Scheduled Appointments:");
        printAppointments(schedule);
        //taking delay time and type
        System.out.print("\nWhen will delay start (M)orning / (A)fternoon: ");
        String delayType = input.next();
        System.out.print("How many minutes the doctor will be late: ");
        int delay = input.nextInt();
        //if delay is in the morning whole schedule shifts by delay time
        if(delayType.equals("M")){
        	//taking, adding delay and inserting again each time object to the array
        	for(int i = 0; i < schedule.size(); i++){
        		Time t = schedule.get(i);
        		t.addTime(delay);
        		schedule.remove(i);
        		schedule.add(i,t);
        	}
        }
        //else, only the afternoon appointments become shifted
        else if(delayType.equals("A")){
        	for(int i = 0; i < schedule.size(); i++){
        		Time t = schedule.get(i);
        		//creating a midday timer
        		Time midday = new Time(12,30);
        		//if Time t is bigger or equal to midday we shift it
        		if(!t.lessThan(midday)){
        			t.addTime(delay);
        			schedule.remove(i);
        			schedule.add(i,t);
        		}
        	}
        }
        //we sort all appointments
        sortAppointments(schedule);
        //printing updated schedule
        System.out.println("\nUpdated appointments:");
        printAppointments(schedule);
    }
}
