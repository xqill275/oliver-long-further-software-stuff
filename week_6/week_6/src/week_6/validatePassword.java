/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_6;

/**
 *
 * @author olive
 */
public class validatePassword {
    
    public boolean passwordLengthCheck(String password){
        if (password.length() < 5 || password.length() > 16) {
            return false;
        }
        return true;
    }
    
    public boolean passwordUppercaseCheck(String password){
        for (int i = 0; i < password.length(); i++){
            if (Character.isUpperCase((password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean passwordLowercaseCheck(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase((password.charAt(i)))){
                return true;
            }
        }
        return false;
    }
    
    public boolean passwordSpecialCharacterCheck(String password) {
        String specialCharacters = "!@#$%^&*()_+[]{}|;:'\",.<>?/\\`~";
        for (int i = 0; i < password.length(); i++) {
            if (specialCharacters.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
            return false;
    }

    public boolean passwordNumberCheck(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
