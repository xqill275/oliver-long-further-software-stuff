/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author olive
 */
public class bankData {
    private ArrayList<String> userNames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<Integer> accountNumbers = new ArrayList<>();
    private ArrayList<Double> accountBalance = new ArrayList<>();
    private int loggedInIndex = 0;

    public ArrayList<String> getUserNames() {
        return userNames;
    }
    
    public ArrayList<String> getPasswords() {
        return passwords;
    }

    public void addToUserArray(String value) {
        userNames.add(value);
    }

    public void addToPasswordArray(String value) {
        passwords.add(value);
    }
    
    public void addToAccountNumberArray(int value) {
        accountNumbers.add(value);
    }
    
    public void addToAccountBalance(double value) {
        accountBalance.add(value);
    }

    public boolean checkValueInArray(String value, ArrayList<String> array) {
        return array.contains(value);
    }
    
    public int getArrayIndex(String value, ArrayList<String> array) {
        return array.indexOf(value);
    }
    
    public void setLoggedInIndex(int id) {
        loggedInIndex = id;
    }
    
    public String getAccountName(){
        return userNames.get(loggedInIndex);
    }
    
    public int getAccountNumber(){
        return accountNumbers.get(loggedInIndex);
    }
    
    public double getAccountBalance(){
        return accountBalance.get(loggedInIndex);
    }
    
    public String getFormattedBalance() {
        double balance = getAccountBalance();
        return String.format("$ %.2f", balance);
    }
    
    public void increaseBalance(int amount) {
        double currentBalance = getAccountBalance();
        currentBalance += amount;
        accountBalance.set(loggedInIndex, currentBalance);
    }
    
    public void decreaseBalance(int amount) {
        double currentBalance = getAccountBalance();
        currentBalance -= amount;
        accountBalance.set(loggedInIndex, currentBalance);
    }
}
