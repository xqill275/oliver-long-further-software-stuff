/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
public class Vehicle {
    private int numWheels;
    private int maxSpeed;
    private int numDoors;
    private int currentSpeed;
    
    public Vehicle (int numWheels, int maxSpeed, int numDoors) {
        this.numWheels = numWheels;
        this.maxSpeed = maxSpeed;
        this.numDoors = numDoors;
        this.currentSpeed = 0;
    }
    
    public int getNumWheels() {
        return numWheels;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }
    
    public int getNumDoors() {
        return numDoors;
    }
    
    public int getCurrentSpeed() {
        return currentSpeed;
    }
    
    public void setNumWheels(int newNum) {
        numWheels = newNum;
    }
    
    public void setMaxSpeed(int newNum) {
        maxSpeed = newNum;
    }
    
    public void setNumDoors(int newNum) {
        numDoors = newNum;
    }
    
    public void setCurrentSpeed(int newNum) {
        currentSpeed = newNum;
    }
    
    public void makeNoise() {
        System.out.println("wow generic vehical sounds");
    }
}
