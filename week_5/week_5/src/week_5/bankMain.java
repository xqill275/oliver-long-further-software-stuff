/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;


import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author olive
 */


public class bankMain extends bankData {
    Scanner sc = new Scanner(System.in);
    private Connection connection;
    public static void main(String[] args) {
        bankMain app = new bankMain();
        app.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nWelcome, " + "\n"
                + "\t1. Login \n"
                + "\t2. Create Account \n"
                + "\t3. Admin \n"
                + "\t4. Exit \n"
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
                case 3 -> admin();
                case 4 -> exit();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public void admin() {
        int choice;
        do {
            System.out.println("\nWelcome, " + "\n"
                + "\t1. Insert \n"
                + "\t2. Delete \n"
                + "\t3. Update \n"
                + "\t4. Exit \n"
                + "Enter your choice: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Consume invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline
            switch (choice) {
                case 1 -> insert();
                case 2 -> delete();
                case 3 -> update();
                case 4 -> run();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
    


    public void insert() {
        System.out.println("Inserting a new user account...");

        // Collect new account information
        System.out.println("Enter username for the new account:");
        String newUserName = sc.nextLine();

        System.out.println("Enter password for the new account:");
        String newPassword = sc.nextLine();

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Check if the username already exists
            String checkQuery = "SELECT COUNT(*) FROM account WHERE name = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, newUserName);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                System.out.println("Username already exists. Cannot insert.");
                connection.close();
                return;
            }

            // Insert new account into the database
            String insertQuery = "INSERT INTO account (name, password) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertQuery);
            insertStmt.setString(1, newUserName);
            insertStmt.setString(2, newPassword);
            insertStmt.executeUpdate();

            System.out.println("New account successfully inserted!");

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while interacting with the database: " + e.getMessage());
        }
    }

    public void delete() {
        System.out.println("Deleting a user account...");

        // Prompt for username to delete
        System.out.println("Enter the username of the account to delete:");
        String userNameToDelete = sc.nextLine();

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Check if the username exists
            String checkQuery = "SELECT COUNT(*) FROM account WHERE name = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, userNameToDelete);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Username not found. Cannot delete.");
                connection.close();
                return;
            }

            // Delete the account from the database
            String deleteQuery = "DELETE FROM account WHERE name = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery);
            deleteStmt.setString(1, userNameToDelete);
            deleteStmt.executeUpdate();

            System.out.println("Account successfully deleted!");

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while interacting with the database: " + e.getMessage());
        }
    }

    public void update() {
        System.out.println("Updating a user account...");

        // Prompt for username to update
        System.out.println("Enter the username of the account to update:");
        String userNameToUpdate = sc.nextLine();

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            // Check if the username exists
            String checkQuery = "SELECT COUNT(*) FROM account WHERE name = ?";
            PreparedStatement checkStmt = connection.prepareStatement(checkQuery);
            checkStmt.setString(1, userNameToUpdate);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Username not found. Cannot update.");
                connection.close();
                return;
            }

            // Prompt for update choice
            System.out.println("What would you like to update?");
            System.out.println("1. Username\n2. Password");
            int choice;
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> {
                    // Update username
                    System.out.println("Enter the new username:");
                    String newUsername = sc.nextLine();

                    // Check if the new username already exists
                    String newCheckQuery = "SELECT COUNT(*) FROM account WHERE name = ?";
                    PreparedStatement newCheckStmt = connection.prepareStatement(newCheckQuery);
                    newCheckStmt.setString(1, newUsername);
                    ResultSet newRs = newCheckStmt.executeQuery();
                    newRs.next();
                    if (newRs.getInt(1) > 0) {
                        System.out.println("This username already exists. Update aborted.");
                        connection.close();
                        return;
                    }

                    String updateQuery = "UPDATE account SET name = ? WHERE name = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setString(1, newUsername);
                    updateStmt.setString(2, userNameToUpdate);
                    updateStmt.executeUpdate();

                    System.out.println("Username successfully updated.");
                }
                case 2 -> {
                    // Update password
                    System.out.println("Enter the new password:");
                    String newPassword = sc.nextLine();

                    String updateQuery = "UPDATE account SET password = ? WHERE name = ?";
                    PreparedStatement updateStmt = connection.prepareStatement(updateQuery);
                    updateStmt.setString(1, newPassword);
                    updateStmt.setString(2, userNameToUpdate);
                    updateStmt.executeUpdate();

                    System.out.println("Password successfully updated.");
                }
                default -> System.out.println("Invalid choice. Update aborted.");
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while interacting with the database: " + e.getMessage());
        }
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
