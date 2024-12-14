/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_4;

/**
 *
 * @author olive
 */
public class bankVersionTwoDataClass {
    private String accountName;
    private String accountNumber;
    private double accountBalance;
    public bankVersionTwoDataClass(String name, String number, double balance) {
        this.accountName = name;
        this.accountNumber = number;
        this.accountBalance = balance;
    }
    
    public String getAccountName() {return accountName;}
    public String getAccountNumber() {return accountNumber;}
    public double getAccountBalance() {return accountBalance;}
    
    public void setAccountBalance(double balance) {accountBalance = balance;}
    
    public String getFormattedBalance() { return String.format("$ %.2f", accountBalance);}
    
}