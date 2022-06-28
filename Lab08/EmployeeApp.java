/**
 * @(#)EmployeeApp.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/4/11
 */

public class EmployeeApp {
    public static void main(String[] args) {
        Project myProject = new Project("SunMarkets POS Implementation",315,320,22);
        Employee e1 = new Employee("Karakus, Zana",215,myProject.getProjectName(),"Information Technologies","IT");
        Employee e2 = new Employee("Rocca, Denis",175,myProject.getProjectName(),"Human Resources","HR");
        Employee e3 = new Employee("Anders, Jamie",275,myProject.getProjectName(),"Human Resources","HR");
        Employee e4 = e1;
        System.out.printf("___________________%n%nEmployees:%n");
        System.out.println(e1.toString()+myProject.toString());
        System.out.println(e2.toString()+myProject.toString());
        System.out.println(e3.toString()+myProject.toString());
        System.out.println(e4.toString()+myProject.toString());
        System.out.println("------- end employee list --------");
        System.out.println("__________________");
        if(e1.department.equals(e2.department)){
        	System.out.println("Employees with Matching Departments (1)");
        	System.out.println(e1.toString()+myProject.toString());
        	System.out.println(e2.toString()+myProject.toString());
        	if(e3.department.equals(e4.department)){
        		System.out.println("__________________");
        		System.out.println("Employees with Matching Departments (2)");
        		System.out.println(e3.toString()+myProject.toString());
        		System.out.println(e4.toString()+myProject.toString());
        	}
        }
        else if(e1.department.equals(e3.department)){
        	System.out.println("Employees with Matching Departments (1)");
        	System.out.println(e1.toString()+myProject.toString());
        	System.out.println(e3.toString()+myProject.toString());
        	if(e2.department.equals(e4.department)){
        		System.out.println("__________________");
        		System.out.println("Employees with Matching Departments (2)");
        		System.out.println(e2.toString()+myProject.toString());
        		System.out.println(e4.toString()+myProject.toString());
        	}
        }
        else if(e1.department.equals(e4.department)){
        	System.out.println("Employees with Matching Departments (1)");
        	System.out.println(e1.toString()+myProject.toString());
        	System.out.println(e4.toString()+myProject.toString());
        	if(e3.department.equals(e2.department)){
        		System.out.println("__________________");
        		System.out.println("Employees with Matching Departments (2)");
        		System.out.println(e2.toString()+myProject.toString());
        		System.out.println(e3.toString()+myProject.toString());
        	}
        }
    }
}
