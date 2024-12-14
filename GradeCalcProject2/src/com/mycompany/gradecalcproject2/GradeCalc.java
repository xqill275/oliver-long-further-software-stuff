package com.mycompany.gradecalcproject2;

public class GradeCalc {
    private int numOfModules;
    private int[] gradeArrayLevelFive;
    private int[] gradeArrayLevelSix;
    private int[] gradeCreditLevelFive;
    private int[] gradeCreditLevelSix;

    public GradeCalc(int numOfModules, int[] gradeArrayLevelFive, int[] gradeArrayLevelSix, int[] gradeCreditLevelFive, int[] gradeCreditLevelSix) {
        this.numOfModules = numOfModules;
        this.gradeArrayLevelFive = gradeArrayLevelFive;
        this.gradeArrayLevelSix = gradeArrayLevelSix;
        this.gradeCreditLevelFive = gradeCreditLevelFive;
        this.gradeCreditLevelSix = gradeCreditLevelSix;
    }

    // Getters
    public int getNumOfModules() {
        return numOfModules;
    }

    public int[] getGradeArrayLevelFive() {
        return gradeArrayLevelFive;
    }

    public int[] getGradeArrayLevelSix() {
        return gradeArrayLevelSix;
    }

    public int[] getGradeCreditLevelFive() {
        return gradeCreditLevelFive;
    }

    public int[] getGradeCreditLevelSix() {
        return gradeCreditLevelSix;
    }

    // Setters
    public void setNumOfModules(int numOfModules) {
        this.numOfModules = numOfModules;
    }

    public void setGradeArrayLevelFive(int[] gradeArrayLevelFive) {
        this.gradeArrayLevelFive = gradeArrayLevelFive;
    }

    public void setGradeArrayLevelSix(int[] gradeArrayLevelSix) {
        this.gradeArrayLevelSix = gradeArrayLevelSix;
    }

    public void setGradeCreditLevelFive(int[] gradeCreditLevelFive) {
        this.gradeCreditLevelFive = gradeCreditLevelFive;
    }

    public void setGradeCreditLevelSix(int[] gradeCreditLevelSix) {
        this.gradeCreditLevelSix = gradeCreditLevelSix;
    }
    
    public String getGradeClassification(double gradeAverage) {
        if (gradeAverage <= 38.0) {
            return "FAIL";
        } else if (gradeAverage <= 48.0) {
            return "3RD";
        } else if (gradeAverage <= 58.0) {
            return "2.2";
        } else if (gradeAverage <= 68.0) {
            return "2.1";
        } else if (gradeAverage <= 100.0 && gradeAverage > 72.0) { // Range for "1st"
            return "1ST";
        } else {
            return "Unclassified"; // For grades above 100 or invalid input
        }
    }


    public int getSumCredits(int[] creditList) {
        int creditTotal = 0;
        for (int i = 0; i < creditList.length; i++) {
            creditTotal += creditList[i];
        }
        return creditTotal;
    }

    public double getGradeAverage(int[] gradeList, int[] creditList) {
        int creditTotal = getSumCredits(creditList);
        double gradeWeightedTotal = 0; 

        for (int i = 0; i < gradeList.length; i++) {
            gradeWeightedTotal += gradeList[i] * creditList[i];
        }
        return gradeWeightedTotal / creditTotal; 
    }

    public double calcMethodA() {
        double levelFiveAverage = getGradeAverage(gradeArrayLevelFive, gradeCreditLevelFive);
        double levelSixAverage = getGradeAverage(gradeArrayLevelSix, gradeCreditLevelSix);
        
        return (levelFiveAverage + levelSixAverage) / 2;
    }
    
    public double calcMethodB(){
        double levelFiveAverage = getGradeAverage(gradeArrayLevelFive, gradeCreditLevelFive);
        double levelSixAverage = getGradeAverage(gradeArrayLevelSix, gradeCreditLevelSix);

        return (levelFiveAverage + levelSixAverage + levelSixAverage) / 3;
    }
    
    public double calcMethodC(){
        double levelSixAverage = getGradeAverage(gradeArrayLevelSix, gradeCreditLevelSix);
        return levelSixAverage;
    }
    
    public void outPut(){
        double finalGradeAverageA = this.calcMethodA();
        double finalGradeAverageB = this.calcMethodB();
        double finalGradeAverageC = this.calcMethodC();

        System.out.println("Calculated method A final weighted average: " + finalGradeAverageA + ". Grade: " + this.getGradeClassification(finalGradeAverageA));
        System.out.println("Calculated method B final weighted average: " + finalGradeAverageB + ". Grade: " + this.getGradeClassification(finalGradeAverageB));
        System.out.println("Calculated method C final weighted average: " + finalGradeAverageC + ". Grade: " + this.getGradeClassification(finalGradeAverageC));
    }
}

