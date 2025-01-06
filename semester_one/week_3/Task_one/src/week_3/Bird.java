/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
public class Bird extends Animal {

    public Bird(String name, int age) {
        super(name, age);
    }
    
    @Override public void displayInfo() {
        System.out.println("Bird's Name: " + name + ", Age: " + age);
    }
    
    @Override public void makeSound() {
        System.out.println("Chirp init");
    }
    
    
    
    
}
