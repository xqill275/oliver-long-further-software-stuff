/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_4;

import java.util.Scanner;
/**
 *
 * @author olive
 */
public class bankInOneFile {
    static String accountName;
    static String accountNumber;
    static double accountBalance;
    static Scanner sc = new Scanner(System.in);
    
    public bankInOneFile(String name, String number, double balance) {
        this.accountName = name;
        this.accountNumber = number;
        this.accountBalance = balance;
    }
    
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nWelcome, " +
                accountName + "\n"
                + "\t1. View account information \n"
                + "\t2. Deposit \n"
                + "\t3. Withdraw \n"
                + "\t4. Exit \n"
                + "Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> viewInfomation();
                case 2 -> deposit();
                case 3 -> withdraw();
                case 4 -> exit();
                default -> System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 4);
        
    }
    
    public static void viewInfomation(){
        System.out.printf("%-20s %-10s %s %n", "Name", "Number", "Balance");
        System.out.println("-".repeat(40));
        System.out.printf("%-20s %-10s $%.2f %n", accountName, accountNumber, accountBalance);
    }
    
    public static void deposit() {
        System.out.print("Enter deposit amount: ");
        int amount = sc.nextInt();
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Successfully deposited $" + amount);
            System.out.println("Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    
    public static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        int amount = sc.nextInt();
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    
    public static void exit() {
        System.out.println("Thank you for using our service!");
    }
}
