/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_6;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author olive
 */
public class BankMain extends BankAccount{
    Scanner sc = new Scanner(System.in);
    public BankMain(String name, String number, double balance) {
        super(name, number, balance);
        
    }
    
    public void main(String[] args) {
        int choice;
        String accountName = getAccountName();
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
    
    public void viewInfomation(){
        String accountName = getAccountName();
        String accountNumber = getAccountNumber();
        double accountBalance = getAccountBalance();
        System.out.printf("%-20s %-10s %s %n", "Name", "Number", "Balance");
        System.out.println("-".repeat(40));
        System.out.printf("%-20s %-10s %s %n", getAccountName(), getAccountNumber(), getFormattedBalance());
    }
    
    public void deposit() {
        double balance = getAccountBalance();
        System.out.print("Enter deposit amount: ");
        int amount = sc.nextInt();
        if (amount > 0) {
            int temp = amount;
            amount += balance;
            setAccountBalance(amount);
            System.out.println("Successfully deposited $" + temp);
            System.out.println("Updated Balance: $" + getAccountBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }   

    public void withdraw() {
        double balance = getAccountBalance();
        System.out.print("Enter withdrawal amount: ");
        int amount = sc.nextInt();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            setAccountBalance(balance);
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("Updated Balance: $" + getAccountBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    
    public static void exit() {
        System.out.println("Thank you for using our service!");
    }
       
}
