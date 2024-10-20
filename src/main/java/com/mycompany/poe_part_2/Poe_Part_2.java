/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part_2;
import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Dawood
 */
public class Poe_Part_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginClass login = new LoginClass(); // Create an instance of LoginClass

        // Variables to store user input
        String firstName, lastName, username, password;

        // User Registration
        firstName = JOptionPane.showInputDialog("Enter first name:");
        lastName = JOptionPane.showInputDialog("Enter last name:");

        do {
            username = JOptionPane.showInputDialog("Enter username:");
            if (!login.checkUserName(username)) {
                JOptionPane.showMessageDialog(null, "Username must contain an underscore and not exceed 5 characters.");
            }
        } while (!login.checkUserName(username));

        do {
            password = JOptionPane.showInputDialog("Enter password:");
            if (!login.checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password must have at least 8 characters, a capital letter, a number, and a special character.");
            }
        } while (!login.checkPasswordComplexity(password));

        login.registerUser(username, password);
        JOptionPane.showMessageDialog(null, "Welcome to DawoodDifference!");

        // Login Process
        boolean loginSuccess = false;
        for (int attempts = 0; attempts < 3; attempts++) {
            String loginUsername = JOptionPane.showInputDialog("Enter your username to login:");
            String loginPassword = JOptionPane.showInputDialog("Enter your password to login:");
            loginSuccess = login.loginUser(loginUsername, loginPassword);
            JOptionPane.showMessageDialog(null, login.returnLoginStatus(loginSuccess));
            if (loginSuccess) break;
        }

        if (!loginSuccess) {
            JOptionPane.showMessageDialog(null, "You have been locked out due to too many failed login attempts.");
            System.exit(0);
        }

        // Main Menu
        while (true) {
            String menuOption = JOptionPane.showInputDialog("Choose an option:\n1) Add Tasks\n2) Coming Soon\n3) Quit");
            switch (menuOption) {
                case "1":
                    addTasks();
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Feature coming soon!");
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, or 3.");
            }
        }
    }

    public static void addTasks() {
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
        Task[] tasks = new Task[numTasks];
        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            tasks[i] = new Task();
            tasks[i].taskName = JOptionPane.showInputDialog("Enter Task Name:");
            tasks[i].developerDetails = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
            do {
                tasks[i].taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                if (!tasks[i].checkTaskDescription()) {
                    JOptionPane.showMessageDialog(null, "Task description must be less than 50 characters.");
                }
            } while (!tasks[i].checkTaskDescription());
            
            tasks[i].taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
            String[] statuses = {"To Do", "Done", "Doing"};
            tasks[i].taskStatus = (String) JOptionPane.showInputDialog(null, "Choose Task Status", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);
            tasks[i].taskID = tasks[i].createTaskID(i);
            
            JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
            totalHours += tasks[i].returnTotalHours();
        }
        
        JOptionPane.showMessageDialog(null, "Total Hours for all tasks: " + totalHours);
    }
}