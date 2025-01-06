/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gradecalcproject2;


/**
 *
 * @author olive
 */
public class GradeCalcProject2 {

    public static void main(String[] args) {

        int numOfModules = 7; 
        
        int[] gradeArrayLevelFive = {70, 70, 75, 50, 76, 58,55};  
        int[] gradeCreditLevelFive = {10, 20, 20, 20, 10, 20, 20}; 

        int[] gradeArrayLevelSix = {65, 70, 70, 70, 58, 51, 35};   
        int[] gradeCreditLevelSix = {20, 40, 20, 10, 10, 10, 10}; 

        new GradeCalcGui(numOfModules, gradeArrayLevelFive, gradeArrayLevelSix, gradeCreditLevelFive, gradeCreditLevelSix);

    }
}

