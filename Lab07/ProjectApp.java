/**
 * @(#)ProjectApp.java
 *
 *
 * @author Oguz Akin
 * @version 1.00 2021/4/3
 */

public class ProjectApp {
    public static void main(String[] args) {
        //Constructing a project object
        Project p1 = new Project("ArcTech Business Solution",11520,215,48);
        //Displaying the project's data
        System.out.println(p1.toString());
        //Constructing a project object
        Project p2 = new Project("SunMarkets POS Implementation",315,320,22);
        //Displaying the project's data
        System.out.println(p2.toString());
        //Constructing a project object
        Project p3 = new Project("HealthTech Hospital",0,0,0);
        //Displaying the project's data
        System.out.println(p3.toString());
        //Comparing projects for their costs
        if(p2.compareProjects(p1.calculateProjectCost())==1){
        	System.out.println("Project with greater cost: ");
        	System.out.println(p1.toString());
        }
        else if(p2.compareProjects(p1.calculateProjectCost())==-1){
        	System.out.println("Project with greater cost: ");
        	System.out.println(p2.toString());
        }
        else if(p2.compareProjects(p1.calculateProjectCost())==0){
        	System.out.println("Projects have equal expenses.");
        }
    }
}
