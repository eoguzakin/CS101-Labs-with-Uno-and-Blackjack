/**
 * @(#)Time.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/4/25
 */


public class Time {
	private int hours;
	private int minutes;
	//Time object
    public Time(int hour, int minute) {
    	hours = hour;
    	minutes = minute;
    }
    //Getters
    public int getHours(){
    	return hours;
    }
    public int getMinutes(){
    	return minutes;
    }
    //Setters
    public void setHours(int hour){
    	if(hour >= 0 && hour <= 23){
    		hours = hour;
    	}
    }
    public void setMinutes(int minute){
    	if(minute <= 59 && minute >= 0){
    		minutes = minute;
    	}
    }
    //Time adding function
    public void addTime(int minute){
    	//adding all the current minutes
    	minutes = minute + minutes;
    	//while minutes > 60, we increment hours and extract 60 from minutes
    	while(minutes >= 60){
    		hours++;
    		minutes = minutes - 60;
    	}
    	//after we stabilize minutes, if hours have become equal or more than 24 we extract 24 from hours
    	if(hours >= 24){
    		hours = hours - 24;
    	}
    }
    //Comparing function
    public boolean lessThan(Time t2){
    	//if t1 hours is less than t2 return true
    	if(getHours() < t2.getHours()){
    		return true;
    	}
    	//if hours are equal and t1 minutes is less than t2, return true
    	//else return false
    	else if(getHours()==t2.getHours()){
    		if(getMinutes()<t2.getMinutes()){
    			return true;
    		}
    		else{
    			return false;
    		}
    	}
    	else{
    		return false;
    	}
    }
    public String toString(){
    	return getHours() + ":" + getMinutes();
    }
    
    
}