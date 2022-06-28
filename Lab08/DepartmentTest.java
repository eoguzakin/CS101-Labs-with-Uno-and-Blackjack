/**
 * @(#)DepartmentTest.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/4/11
 */


public class DepartmentTest {

    public static void main(String[] args){
    	Department d1 = new Department("Pars","E201");
    	Department d3 = d1;
    	Department d2 = new Department("Coupar","E201");
    	System.out.println(d2.toString());
    	System.out.println(d1.getDeptName());
    	System.out.println(d2.getDeptName());
    	d1.setDeptName("Coupar");
    	System.out.println(d1.getDeptName());
    	System.out.println(d2.getDeptName());
    	if(d1.getDeptName()==d2.getDeptName()){
    		System.out.println("1yes equality");
    	}
    	if(d1.equals(d2)){
    		System.out.println("2yes equals");
    	}
    	if(d1.equals(d3)){
    		System.out.println("3yes project equals");
    	}
    	if(d1==d3){
    		System.out.println("4yes project equality");
    	}
    	if(d1==d3){
    		System.out.println("5yes false  equality");
    	}
    	if(d1.equals(d3)){
    		System.out.println("6yes false  equals");
    	}
    	if(d1==d2){
    		System.out.println("7 equality operator equals");
    	}
    }
    
    
}