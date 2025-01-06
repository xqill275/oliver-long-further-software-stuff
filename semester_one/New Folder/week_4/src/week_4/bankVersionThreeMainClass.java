/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_4;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author olive
 */
public class bankVersionThreeMainClass extends bankVersionThreeDataClass {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        bankVersionThreeMainClass app = new bankVersionThreeMainClass();
        app.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nWelcome, " + "\n"
                + "\t1. Login \n"
                + "\t2. Create Account \n"
                + "\t3. Exit \n"
                + "Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Consume invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline
            switch (choice) {
                case 1 -> login();
                case 2 -> createAccount();
                case 3 -> exit();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public void createAccount() {
        String userName;
        String password;
        boolean error;
        do {
            System.out.println("Welcome! Please enter a username:");
            userName = sc.nextLine();
            error = checkValueInArray(userName, getUserNames());
            if (error) {
                System.out.println("Username already exists. Please try a different one.");
            }
        } while (error);

        System.out.println("Great! Now please enter a password:");
        password = sc.nextLine();
        
        int accountNum = getUserNames().size();
        addToUserArray(userName);
        addToPasswordArray(password);
        addToAccountNumberArray(accountNum);
        addToAccountBalance(0);
        System.out.println("Account created successfully!");
    }

    public void exit() {
        System.out.println("Exiting program. Goodbye!");
        System.exit(0);
    }

    public void login() {
        System.out.println("Hello Again! Please enter your username:");
        String userName = sc.nextLine();
        
        System.out.println(getUserNames());
        System.out.println(getPasswords());
        
        System.out.println("Next, your password, please:");
        String password = sc.nextLine();

        // Check if username exists
        if (!checkValueInArray(userName, getUserNames())) {
            System.out.println("Your username is incorrect.");
            return;
        }

        // Get index of the username
        int userIndex = getArrayIndex(userName, getUserNames());

        // Verify password
        String storedPassword = getPasswords().get(userIndex);
        if (!storedPassword.equals(password)) {
            System.out.println("Your password is incorrect.");
            return;
        }

        // Login successful
        System.out.println("Login successful! Welcome back, " + userName + ".");
        setLoggedInIndex(userIndex);
        
        mainMenu();
    } 
    
    public void mainMenu() {
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
                case 4 -> run();
                default -> System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 4);
    }
    
    public void viewInfomation(){
        System.out.printf("%-20s %-10s %s %n", "Name", "Number", "Balance");
        System.out.println("-".repeat(40));
        System.out.printf("%-20s %-10s %s %n", getAccountName(), getAccountNumber(), getFormattedBalance());
    }
    
        public void deposit() {
        double balance = getAccountBalance();
        System.out.print("Enter deposit amount: ");
        int amount = sc.nextInt();
        if (amount > 0) {
            increaseBalance(amount);
            System.out.println("Successfully deposited $" + amount);
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
            decreaseBalance(amount);
            System.out.println("Successfully withdrew $" + amount);
            System.out.println("Updated Balance: $" + getAccountBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
}
