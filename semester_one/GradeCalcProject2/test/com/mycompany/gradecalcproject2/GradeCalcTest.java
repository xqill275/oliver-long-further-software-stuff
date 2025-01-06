package com.mycompany.gradecalcproject2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author olive
 */
public class GradeCalcTest {

    @Test
    public void testGetGradeClassification() {
        GradeCalc calc = createTestGradeCalc();
        
        assertEquals("Grade 35.0 should return FAIL", "FAIL", calc.getGradeClassification(35.0));
        assertEquals("Grade 45.0 should return 3RD", "3RD", calc.getGradeClassification(45.0));
        assertEquals("Grade 55.0 should return 2.2", "2.2", calc.getGradeClassification(55.0));
        assertEquals("Grade 65.0 should return 2.1", "2.1", calc.getGradeClassification(65.0));
        assertEquals("Grade 75.0 should return 1ST", "1ST", calc.getGradeClassification(75.0));
        assertEquals("Grade 105.0 should return Unclassified", "Unclassified", calc.getGradeClassification(105.0));
    }

    @Test
    public void testCalcMethodA() {
        GradeCalc calc = createTestGradeCalc();
        
        assertEquals("Method A calculation is incorrect", 66.66, calc.calcMethodA(), 0.01);
    }

    @Test
    public void testCalcMethodB() {
        GradeCalc calc = createTestGradeCalc();
        
        assertEquals("Method B calculation is incorrect", 67.77, calc.calcMethodB(), 0.01);
    }

    @Test
    public void testCalcMethodC() {
        GradeCalc calc = createTestGradeCalc();
        
        double expected = 70.0; // Only level 6 average
        assertEquals("Method C calculation is incorrect", expected, calc.calcMethodC(), 0.01);
    }

    @Test
    public void testGetBestGradeWithNaNValues() {
        int[] level5Grades = new int[]{};
        int[] level5Credits = new int[]{};
        int[] level6Grades = new int[]{70, 80}; // Only level 6 has grades
        int[] level6Credits = new int[]{20, 20};

        GradeCalc calc = new GradeCalc(2, level5Grades, level6Grades, level5Credits, level6Credits);

        String bestGrade = calc.getBestGrade();
        assertEquals("Best grade should handle NaN and return '1ST'", "1ST", bestGrade);
    }

    @Test
    public void testGetSumCredits() {
        int[] credits = {10, 20, 30};
        GradeCalc calc = createTestGradeCalc();
        
        int expectedSum = 10 + 20 + 30;
        assertEquals("Sum of credits is incorrect", expectedSum, calc.getSumCredits(credits));
    }

    @Test
    public void testGetGradeAverage() {
        int[] grades = {50, 60, 70};
        int[] credits = {10, 20, 30};
        GradeCalc calc = createTestGradeCalc();
        
        double expectedAverage = (50 * 10 + 60 * 20 + 70 * 30) / 60.0;
        assertEquals("Weighted average is incorrect", expectedAverage, calc.getGradeAverage(grades, credits), 0.01);
    }

    /**
     * Helper method to create a default GradeCalc instance.
     */
    private GradeCalc createTestGradeCalc() {
        int[] level5Grades = {50, 60, 70};
        int[] level5Credits = {10, 20, 30};
        int[] level6Grades = {65, 75, 70};
        int[] level6Credits = {20, 20, 20};
        
        return new GradeCalc(3, level5Grades, level6Grades, level5Credits, level6Credits);
    }
}
