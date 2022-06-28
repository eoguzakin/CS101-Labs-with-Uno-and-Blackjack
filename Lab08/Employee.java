/**
 * @(#)Employee.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/4/11
 */


public class Employee {
	//Constants
	public final int WORKING_DAYS = 261;
	//Instances
	private String employeeName;
	private double dailyRate;
	private String depName;
	private String depCode;
	private String project;
	//Department object of this employee
	public Department department;
	
    public Employee(String eName, double eDailyRate, String eProject, String eDepName, String eDepCode){
    	employeeName = eName;
    	dailyRate = eDailyRate;
    	project = eProject;
    	depName = eDepName;
    	depCode = eDepCode;
    	department = new Department(depName,depCode);
    }
    //Copy constructor
    public Employee(Employee eCopy){
    	employeeName = eCopy.employeeName;
    	dailyRate = eCopy.dailyRate;
    	project = eCopy.project;
    	depName = eCopy.depName;
    	depCode = eCopy.depCode;
    	department = eCopy.department;
    }
    //Getters
    public String getEmployeeName(){
    	return employeeName;
    }
    public double getDailyRate(){
    	return dailyRate;
    }
    public String getDepartment(){
    	return depName;
    }
    public String getProject(){
    	return project;
    }
    //Setters
    public void setEmployeeName(String newName){
    	employeeName = newName;
    }
    public void setDailyRate(double rate){
    	dailyRate = rate;
    }
    public void setDepartment(String newDepName, String newDepCode){
    	depName = newDepName;
    	depCode = newDepCode;
    }
    public void setProject(String newProjectName){
    	project = newProjectName;
    }
    //Services
    public double calculateYearlySalary(){
    	return WORKING_DAYS * dailyRate;
    }
    public String toString(){
    	String s = "";
    	s = "\nEmployee Name: " + employeeName + " Yearly Salary: " +calculateYearlySalary();
    	s = s + "\n" + department.toString();
    	return s;
    }
}