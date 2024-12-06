/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
class Dog extends Animal {
    public Dog(String name, int age) {
    super(name, age);
    }
    
    // Specific method for Dog
    public void bark() {
        System.out.println(name + " is barking.");
    }

    // Overriding displayInfo method
    @Override public void displayInfo() {
        System.out.println("Dog's Name: " + name + ", Age: " + age);
    }
    
    @Override public void makeSound() {
        System.out.println("woof init");
    }
}
