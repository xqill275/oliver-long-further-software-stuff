/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week_2;

import java.util.Scanner;

/**
 *
 * @author olive
 */
public class week_2_task_one {

    /**
     * @param args the command line arguments
     */
    
    public static int countWords(String sentence){
        String[] newSentence = sentence.split(" ");
        return newSentence.length;
    }
    
    public static String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reverse = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i-- ){
            reverse.append(words[i]);
            if (i != 0) {
                reverse.append(" ");
            }
        }
        return reverse.toString();
    }
    
    public static String replaceSpaceUnderscore(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder replaced = new StringBuilder();
        
        for (int i = 0; i < words.length; i++){
            replaced.append(words[i]);
            replaced.append("_");
        }
        return replaced.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a sentence");
        String sentence = scanner.nextLine();
        int numWords = countWords(sentence);
        String reverse = reverseSentence(sentence);
        int hasJava = 0;
        if (sentence.contains("Java")) {
            hasJava = 1;
        }
        String underScored = replaceSpaceUnderscore(sentence);
        
        
        System.out.println("Base sentence: " + sentence);
        System.out.println("Upper case: " + sentence.toUpperCase());
        System.out.println("Number of words: " + numWords);
        System.out.println("Reversed: " + reverse);
        if (hasJava == 0){
            System.out.println("Contains the word Java: False");
        } else {
            System.out.println("Contains the word Java: True");
        }
        System.out.println("_ in stead of spaces: " + underScored);
        
        
        
        
    }
    
}
