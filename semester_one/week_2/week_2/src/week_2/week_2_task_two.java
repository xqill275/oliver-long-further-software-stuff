/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_2;


/**
 *
 * @author olive
 */
public class week_2_task_two {
    public static void main(String[] args) {
       Employee oliver = new Employee(0,"oliver", "long", "softwareDev");
       System.out.println("ID: " + oliver.getID());
       System.out.println("FirstName: " + oliver.getFirstName());
       System.out.println("LastName: " + oliver.getLastName());
       System.out.println("Job: " + oliver.getJob());
       
       oliver.setID(100);
       oliver.setFirstName("Dave");
       oliver.setLastName("DaveSon");
       oliver.setJob("being kinda cool i guess");

       System.out.println("ID: " + oliver.getID());
       System.out.println("FirstName: " + oliver.getFirstName());
       System.out.println("LastName: " + oliver.getLastName());
       System.out.println("Job: " + oliver.getJob());       
        
    }
}
