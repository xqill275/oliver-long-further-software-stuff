/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
public class Task_one {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle(0,0,0);
        Car car = new Car(0,0,0);
        Bike bike = new Bike(0,0,0);
        Truck truck = new Truck(0,0,0);
        
        vehicle.makeNoise();
        car.makeNoise();
        bike.makeNoise();
        truck.makeNoise();
    }
    
}
