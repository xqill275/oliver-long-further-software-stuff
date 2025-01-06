/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_2;

/**
 *
 * @author olive
 */
public class Employee {
    private int ID;
    private String firstName;
    private String lastName;
    private String Job;
    
    public Employee(int ID, String firstName, String lastName, String Job){
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Job = Job;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getJob() {
        return Job;
    }
    
    public void setID(int newID) {
        ID = newID;
    }
    
    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName) {
        lastName = newLastName;
    }
    
    public void setJob(String newJob) {
        Job = newJob;
    }
    
}
