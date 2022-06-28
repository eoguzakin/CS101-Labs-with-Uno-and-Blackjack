/**
 * @(#)Department.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/4/11
 */


public class Department {
	//Instances
	private String deptName;
	private String deptCode;
	
    public Department(String name, String code){
    	deptName = name;
    	deptCode = code;
    }
    //Getters
    public String getDeptName(){
    	return deptName;
    }
    public String getDeptCode(){
    	return deptCode;
    }
    //Setters
    public void setDeptName(String newName){
    	deptName = newName;
    }
    public void setDeptCode(String newCode){
    	deptCode = newCode;
    }
    //Services
    public boolean equals( Department other ){
      	return deptName.equals(other.deptName) && deptCode.equals(other.deptCode);
   	}
   	public String toString(){
   		return "DeptName: " + deptName + " Dept Code: "+ deptCode;
   	}
    
}