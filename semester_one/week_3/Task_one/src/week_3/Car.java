/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
public class Car extends Vehicle {
    public Car (int numWheels, int maxSpeed, int numDoors) {
        super(numWheels, maxSpeed, numDoors);
    }
    
    @Override public void makeNoise() {
        System.out.println("Car sound");
    }
    
}
