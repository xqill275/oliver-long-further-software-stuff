/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gradecalcproject2;

import com.mycompany.gradecalcproject2.GradeCalc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author olive
 */
public class GradeCalcGui extends GradeCalc {
    private Connection connection;
    public GradeCalcGui(int numOfModules, int[] gradeArrayLevelFive, int[] gradeArrayLevelSix, int[] gradeCreditLevelFive, int[] gradeCreditLevelSix){
      super(numOfModules, gradeArrayLevelFive, gradeArrayLevelSix, gradeCreditLevelFive, gradeCreditLevelSix);
      try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradecalc", "pma", "");
            System.out.println("Connected With the database successfully");
      } catch (Exception e) {
          System.out.println(e);
      }
      CreateAndShowGui();
    }
    
    private void CreateAndShowGui(){
        JFrame frame = new JFrame("Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2, 10, 10));
        
        JLabel lblNumModules = new JLabel("Number of Modules:");
        JTextField txtNumModules = new JTextField();
        
        JLabel lblLevel5Grades = new JLabel("Level 5 Grades (comma-separated):");
        JTextField txtLevel5Grades = new JTextField();
                
        JLabel lblLevel6Grades = new JLabel("Level 6 Grades (comma-separated):");
        JTextField txtLevel6Grades = new JTextField();

        JLabel lblLevel5Credits = new JLabel("Level 5 Credits (comma-separated):");
        JTextField txtLevel5Credits = new JTextField();

        JLabel lblLevel6Credits = new JLabel("Level 6 Credits (comma-separated):");
        JTextField txtLevel6Credits = new JTextField();
        
        inputPanel.add(lblNumModules);
        inputPanel.add(txtNumModules);
        inputPanel.add(lblLevel5Grades);
        inputPanel.add(txtLevel5Grades);
        inputPanel.add(lblLevel6Grades);
        inputPanel.add(txtLevel6Grades);
        inputPanel.add(lblLevel5Credits);
        inputPanel.add(txtLevel5Credits);
        inputPanel.add(lblLevel6Credits);
        inputPanel.add(txtLevel6Credits);
        
        JButton calculateButton = new JButton("Calculate Grade");
        JButton leaderboardButton = new JButton("Grade Leaderboard");

        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numModules = Integer.parseInt(txtNumModules.getText());
                    int[] level5Grades = parseArray(txtLevel5Grades.getText());
                    int[] level6Grades = parseArray(txtLevel6Grades.getText());
                    int[] level5Credits = parseArray(txtLevel5Credits.getText());
                    int[] level6Credits = parseArray(txtLevel6Credits.getText());

                    // Update the data in GradeCalc
                    setNumOfModules(numModules);
                    setGradeArrayLevelFive(level5Grades);
                    setGradeArrayLevelSix(level6Grades);
                    setGradeCreditLevelFive(level5Credits);
                    setGradeCreditLevelSix(level6Credits);

                    // Perform calculations and display result
                    double finalGradeAverageA = calcMethodA(); // Example using Method A
                    double finalGradeAverageB = calcMethodB();
                    double finalGradeAverageC = calcMethodC();
                    
                    String gradeClassA = getGradeClassification(finalGradeAverageA);
                    String gradeClassB = getGradeClassification(finalGradeAverageB);
                    String gradeClassC = getGradeClassification(finalGradeAverageC);
                    String bestGrade = getBestGrade();
                            
                    
                    String resultMessage = String.format(
                        "Method A: Final Average = %.2f, Grade = %s\n" +
                        "Method B: Final Average = %.2f, Grade = %s\n" +
                        "Method C: Final Average = %.2f, Grade = %s",
                        finalGradeAverageA, gradeClassA,
                        finalGradeAverageB, gradeClassB,
                        finalGradeAverageC, gradeClassC,
                        bestGrade
                    );
                    JOptionPane.showMessageDialog(frame, resultMessage, "Grade Calculation Results", JOptionPane.INFORMATION_MESSAGE);
                    uploadToDb(txtNumModules,txtLevel5Grades,txtLevel6Grades,txtLevel5Credits,txtLevel6Credits, bestGrade);
                } catch (Exception ex) {
                     JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayLeaderboard();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateButton);
        buttonPanel.add(leaderboardButton);

        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }
    
    private int[] parseArray(String input){
        String[] parts = input.split(",");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }
        return result;
    }
    
    
    private void uploadToDb(JTextField txtNumModules, JTextField txtLevel5Grades, JTextField txtLevel6Grades, JTextField txtLevel5Credits, JTextField txtLevel6Credits, String bestGrade) {
        try {
            String sql = "INSERT INTO gradedb (NumModles, GradesLV5, CreditsLV5, GradesLV6, CreditsLV6, gradeFinal) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Parse and set the values
            int numModules = Integer.parseInt(txtNumModules.getText().trim());
            String level5Grades = txtLevel5Grades.getText().trim();
            String level6Grades = txtLevel6Grades.getText().trim();
            String level5Credits = txtLevel5Credits.getText().trim();
            String level6Credits = txtLevel6Credits.getText().trim();

            preparedStatement.setInt(1, numModules);
            preparedStatement.setString(2, level5Grades);
            preparedStatement.setString(3, level6Grades);
            preparedStatement.setString(4, level5Credits);
            preparedStatement.setString(5, level6Credits);
            preparedStatement.setString(6, bestGrade);
            

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Provide feedback
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully into the database.");
            } else {
                System.out.println("No rows were affected. Data not inserted.");
            }

            // Close resources
            preparedStatement.close();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Failed to upload data to the database: " + e.getMessage());
        }
    }
    
    private void displayLeaderboard() {
        try {
            String sql = "SELECT gradeFinal FROM gradedb ORDER BY gradeFinal ASC";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            StringBuilder leaderboard = new StringBuilder("Grade Leaderboard:\n");
            while (resultSet.next()) {
                leaderboard.append(resultSet.getString("gradeFinal")).append("\n");
            }
            
            JOptionPane.showMessageDialog(null, leaderboard.toString(), "Leaderboard", JOptionPane.INFORMATION_MESSAGE);
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Failed to fetch leaderboard: " + e.getMessage());
        }
    }
}
    

