/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    // Specific method for Cat
    public void meow() {
        System.out.println(name + " is meowing.");
    }
    // Overriding displayInfo method
    @Override public void displayInfo() {
        System.out.println("Cat's Name: " + name + ", Age: " + age);
    }
    
    @Override public void makeSound() {
        System.out.println("Meow init");
    }
}
