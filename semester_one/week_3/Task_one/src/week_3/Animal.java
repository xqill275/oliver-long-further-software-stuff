/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_3;

/**
 *
 * @author olive
 */

public class Animal {
    String name;
    int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void eat() {
        System.out.println(name + " is eating.");
    }
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
    
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

