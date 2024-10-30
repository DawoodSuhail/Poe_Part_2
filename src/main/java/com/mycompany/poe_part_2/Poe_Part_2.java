/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part_2;

// Import necessary classes for user input and UI prompts
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Dawood
 */
public class Poe_Part_2 {
    
    // Set to store usernames registered in the current session
    private static final Set<String> registeredUsernames = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for console input (not used in this code)
        LoginClass login = new LoginClass(); // Create an instance of LoginClass for user registration and login
        
        boolean registered = false; // Flag to check if a user is registered
        boolean loggedIn = false; // Flag to check if a user is logged in

        // Main Menu loop
        while (true) {
            // Display menu options and get user input
            String menuOption = JOptionPane.showInputDialog("Choose an option:\n1) Register User\n2) Login\n3) Cancel");

            switch (menuOption) {
                case "1":
                    // User Registration process
                    registered = registerUser(login);
                    break;
                case "2":
                    // Login Process
                    if (registered) { // Check if a user is registered before logging in
                        loggedIn = loginUser(login); // Attempt to log in the user
                        if (loggedIn) { // If login is successful
                            mainAppMenu(); // Proceed to main application menu
                        }
                    } else {
                        // Prompt to register if not already done
                        JOptionPane.showMessageDialog(null, "Please register first before logging in.");
                    }
                    break;
                case "3":
                    // Exit the application
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    System.exit(0); // Terminate the program
                default:
                    // Handle invalid menu option
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, or 3.");
            }
        }
    }

    private static boolean registerUser(LoginClass login) {
        // Variables to store user input
        String firstName, lastName, username, password;

        // Get user's first and last name through input dialog
        firstName = JOptionPane.showInputDialog("Enter first name:");
        lastName = JOptionPane.showInputDialog("Enter last name:");

        // Loop to get a valid username
        do {
            // Prompt user for a username with specific formatting requirements
            username = JOptionPane.showInputDialog("Enter username:\nUsername must contain an underscore (_) and not exceed 5 characters.");
            
            // Check if the username is already registered in this session
            if (registeredUsernames.contains(username)) {
                // Inform the user if the username is taken
                JOptionPane.showMessageDialog(null, "This Username is unavailable. Please select another username.");
            } else if (!login.checkUserName(username)) {
                // Inform the user if the username format is incorrect
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            } else {
                // Confirm successful capture of the username
                JOptionPane.showMessageDialog(null, "Username successfully captured.");
                break; // Exit the loop if the username is valid and not already registered
            }
        } while (true);

        // Loop to get a valid password
        do {
            // Prompt user for a password with specific complexity requirements
            password = JOptionPane.showInputDialog("Enter password:\nPassword should contain at least 8 characters, a capital letter, a number, and a special character.");
            if (!login.checkPasswordComplexity(password)) {
                // Inform the user if the password format is incorrect
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            } else {
                // Confirm successful capture of the password
                JOptionPane.showMessageDialog(null, "Password successfully captured.");
                break; // Exit the loop if the password is valid
            }
        } while (true);

        // Add the new username to the set to mark it as registered in this session
        registeredUsernames.add(username);

        // Call registerUser method in LoginClass and show confirmation message
        JOptionPane.showMessageDialog(null, login.registerUser(firstName, lastName, username, password));
        return true; // Return true to indicate registration success
    }

    private static boolean loginUser(LoginClass login) {
        boolean loginSuccess = false; // Flag to track login success

        // Allow up to 3 attempts to login
        for (int attempts = 3; attempts > 0; attempts--) {
            String loginUsername = JOptionPane.showInputDialog("Enter your username to login:");

            // Check if the username exists and is registered in the current session
            if (!registeredUsernames.contains(loginUsername)) {
                // Inform the user of an incorrect username and the remaining attempts
                JOptionPane.showMessageDialog(null, 
                    """
                    The username you have entered is incorrect or has not been registered. Please try again.
                    Attempts remaining: """ + (attempts - 1));
                continue; // Prompt for username again without using up an attempt
            }

            String loginPassword = JOptionPane.showInputDialog("Enter your password to login:");

            // Validate the username and password
            loginSuccess = login.loginUser(loginUsername, loginPassword);

            if (!loginSuccess) {
                // Inform the user of an incorrect password and the remaining attempts
                JOptionPane.showMessageDialog(null, 
                    """
                    The password you have entered is incorrect. Please try again.
                    Attempts remaining: """ + (attempts - 1));
            } else {
                // If login is successful, greet the user
                JOptionPane.showMessageDialog(null, "Welcome Suhail Dawood, it is great to see you .");
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
                return true; // Return true to indicate successful login
            }
        }

        // Lock the user out after too many failed attempts
        JOptionPane.showMessageDialog(null, "You have been locked out due to too many failed login attempts.");
        System.exit(0); // Terminate the program on lockout
        return false; // Return false to indicate login failure
    }

    private static void mainAppMenu() {
        // Main Application Menu after successful login
        while (true) {
            // Display main application menu options
            String menuOption = JOptionPane.showInputDialog("Choose an option:\n1) Add Tasks\n2) Show report\n3) Quit");
            switch (menuOption) {
                case "1":
                    // Call the method to add tasks
                    addTasks();
                    break;
                case "2":
                    // Placeholder for showing reports (functionality coming soon)
                    JOptionPane.showMessageDialog(null, "Coming soon");
                    break;
                case "3":
                    // Exit the application
                    JOptionPane.showMessageDialog(null, "Exiting the application.");
                    System.exit(0); // Terminate the program
                default:
                    // Handle invalid menu option
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, or 3.");
            }
        }
    }

    public static void addTasks() {
        // Prompt user for the number of tasks they want to enter
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter?"));
        Task[] tasks = new Task[numTasks]; // Array to hold task objects
        int totalHours = 0; // Variable to accumulate total hours for all tasks

        // Loop to enter task details
        for (int i = 0; i < numTasks; i++) {
            // Prompt user for task name
            String taskName = JOptionPane.showInputDialog("Enter Task Name:");
            // Prompt user for developer details
            String developerDetails = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
            String taskDescription;

            // Loop to get a valid task description
            do {
                // Prompt user for task description (max 50 characters)
                taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
                if (taskDescription.length() > 50) {
                    // Inform the user if the description exceeds the character limit
                    JOptionPane.showMessageDialog(null, "Task description must be less than 50 characters.");
                }
            } while (taskDescription.length() > 50); // Repeat until a valid description is entered

            // Prompt user for task duration in hours
            int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration (hours):"));
            // Array of possible task statuses
            String[] statuses = {"To Do", "Done", "Doing"};
            // Prompt user to select a task status
            String taskStatus = (String) JOptionPane.showInputDialog(null, "Choose Task Status", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statuses, statuses[0]);

            // Create task object with the constructor and set its number
            tasks[i] = new Task(taskDescription, taskName, developerDetails, taskDuration, i + 1); // Pass taskNumber as i + 

        tasks[i].setTaskStatus(taskStatus);
        tasks[i].setTaskID(tasks[i].createTaskID(i));
        
        JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
        totalHours += tasks[i].returnTotalHours();
    }

    JOptionPane.showMessageDialog(null, "Total Hours for all tasks: " + totalHours);
}
}