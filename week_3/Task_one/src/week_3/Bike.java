/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
public class Bike extends Vehicle {
    public Bike (int numWheels, int maxSpeed, int numDoors) {
        super(numWheels, maxSpeed, numDoors);
    }
    
    @Override public void makeNoise() {
        System.out.println("cool bike sound");
    }
}
