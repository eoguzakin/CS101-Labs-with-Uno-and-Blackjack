/**
 * @(#)Project.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/4/3
 */


public class Project {
	//Constants
	public final double TAX = 0.13;
	public final int OVERHEAD = 50000;
	public final int EMP_HOURS_WEEK = 45;
	//Statics
	public static int projectCounter = 5000;
	//Instance Data Members
	private String projectId;
	private String projectName;
	private String projectType;
	private double personHours;
	private double ratePerHour;
	private double projectWeeks;
	private double projectCost;
	private int teamSize;
    public Project(String pName, double PersonHours, double RatePerHour,double ProjectWeeks){
    	//incrementing project counter to set the id
    	projectCounter++;
    	//assigning the project name
    	this.projectName = pName;
    	//assembling the project id
    	projectId = getProjectId();
    	//assigning personHours
    	this.personHours = PersonHours;
    	//assigning ratePerHour
    	this.ratePerHour = RatePerHour;
    	//assigning weeks
    	this.projectWeeks = ProjectWeeks;
    	//calculating the team size
    	teamSize = calculatePersonResources();
    	//calculating the project cost
    	projectCost = (long)calculateProjectCost();
    	//setting the project type according to the cost
    	projectType = getProjectType();
    }
    
    //ACCESSORS OR GETTERS
    //This one accesses the project name
    public String getProjectName(){
    	return projectName;
    }
    //This one accesses the id
    private String getProjectId(){
    	return 2021 + "-" + projectCounter;
    }
    //This one accesses the project type which is decided according to cost
    public String getProjectType(){
    	if(projectCost>1000000){
    		projectType = "m";
    	}
    	else if(500000<=projectCost && projectCost<=1000000){
    		projectType = "l";
    	}
    	else if(0<projectCost && projectCost<500000){
    		projectType = "s";
    	}
    	else if(0==projectCost){
    		projectType = "i";
    	}
    	return projectType;
    }
    //This one accesses personHours data
    public double getPersonHours(){
    	if(personHours>0){
    		return personHours;
    	}
    	else{
    		return 0;
    	}
    }
    //This one accesses ratePerHour data
    public double getRatePerHour(){
    	if(ratePerHour>0){
    		return ratePerHour;
    	}
    	else{
    		return 0;
    	}
    }
    //This one accesses projectWeeks data
    public double getProjectWeeks(){
    	if(projectWeeks>0){
    		return projectWeeks;
    	}
    	else{
    		return 0;
    	}
    }
    
    //MUTATORS OR SETTERS
    //This one sets the project name
    public void setProjectName(String newName){
    	projectName = newName;
    }
    //This one sets the projectId
    private void setProjectId(){
    	projectId = 2021 + "-" + (projectCounter++);
    }
    //This one sets the project type after the cost becomes modified
    public String setProjectType(double projectCost){
    	if(projectCost>1000000){
    		projectType = "m";
    	}
    	else if(500000<=projectCost && projectCost<=1000000){
    		projectType = "l";
    	}
    	else if(0<projectCost && projectCost<500000){
    		projectType = "s";
    	}
    	else if(0==projectCost){
    		projectType = "i";
    	}
    	return projectType;
    }
    //This one changes personHours data
    public void setPersonHours(double newPersonHours){
    	if(newPersonHours>0){
    		personHours = newPersonHours;
    	}
    	else{
    		personHours = 0;
    	}
    }
    //This one changes ratePerHour data
    public void setRatePerHour(double newRate){
    	if(newRate>0){
    		ratePerHour = newRate;
    	}
    	else{
    		ratePerHour = 0;
    	}
    }
    //This one changes projectWeeks data
    public void setProjectWeeks(double newWeek){
    	if(newWeek>0){
    		projectWeeks = newWeek;
    	}
    	else{
    		projectWeeks = 0;
    	}
    }
    
    //SERVICE METHODS
    //This one deactivates the project by setting personHours and ratePerHour to 0 and projectType to "i"
    public void deactivateProject(){
    	personHours = 0;
    	ratePerHour = 0;
    	projectType = "i";
    }
    //This one activates the project after assigning backups to their counterparts and setting the projectType again
    public void activateProject(double person, double rate){
    	setRatePerHour(rate);
    	setPersonHours(person);
    	calculateProjectCost();
    	projectType = setProjectType(projectCost);
    }
    //This one calculates the projectCost
    //If cost is less than 20000, the overhead cost is not added to the sum
    public double calculateProjectCost(){
    	double costBefore = (personHours * ratePerHour);
    	if(costBefore<20000){
    		projectCost = costBefore;
    	}
    	else{
    		projectCost = Math.round((costBefore + OVERHEAD) * (TAX+1));
    	}
    	return projectCost;
    }
    //This one calculates the teamsize
    public int calculatePersonResources(){
    	return (int)Math.round(personHours / (EMP_HOURS_WEEK * projectWeeks));
    }
    //This one compares this project and the project passed as a parameter
    public int compareProjects( double cost1){
    	if(cost1>projectCost){
    		return 1;
    	}
    	else if(cost1==projectCost){
    		return 0;
    	}
    	else{
    		return -1;
    	}
    }
    //This one outputs the data of this project object
    public String toString(){
    	if(projectType.equals("i")){
    		return "------INACTIVE PROJECT------\nProject Name: " + projectName + "\nProject ID: " + projectId+"\n";
    	}
    	else{
    		return "Project Name: " + projectName + "\nProject ID: " + projectId + "\nProject Type: " + projectType + "\nTeam Size: " + teamSize + "\nEstimated Project Cost: " + projectCost+"\n";
    	}
    }
    
}