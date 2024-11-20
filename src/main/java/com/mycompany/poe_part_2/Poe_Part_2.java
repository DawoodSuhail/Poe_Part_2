/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part_2;

// Import necessary classes for user input and UI prompts
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Dawood
 */
/**
 * Main application class for task management with user authentication.
 */
public class Poe_Part_2 {

 // Arrays for user authentication
    private static List<String> firstNames = new ArrayList<>();
    private static List<String> lastNames = new ArrayList<>();
    private static List<String> usernames = new ArrayList<>();
    private static List<String> passwords = new ArrayList<>();

    // Arrays for task management
    private static List<String> developers = new ArrayList<>();
    private static List<String> taskNames = new ArrayList<>();
    private static List<String> taskIDs = new ArrayList<>();
    private static List<Integer> taskDurations = new ArrayList<>();
    private static List<String> taskStatuses = new ArrayList<>();

   public static void main(String[] args) {
       
    boolean authenticated = false;

    while (!authenticated) {
        String preMenu = """
                Please select an option:
                1. Register
                2. Login
                3. Exit
                Enter your choice:
                """; 

        String choiceString = JOptionPane.showInputDialog(preMenu);
        if (choiceString == null) break; // Exit if user cancels
        int choice = Integer.parseInt(choiceString);

        switch (choice) {
            case 1 -> registerUser();
            case 2 -> authenticated = loginUser();
            case 3 -> {
                JOptionPane.showMessageDialog(null, "Exiting... Goodbye!");
                System.exit(0);
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
        }
    }

    if (authenticated) {
        runMainApplication(); // Proceed to Main Menu
    }
}
    
    // A method to get the current logged-in username for welcome message
    private static String getCurrentUsername() {
        String username = JOptionPane.showInputDialog("Enter your username:");
        return username;
    }

    /**
     * Handles user registration.
     */
   private static void registerUser() {
    String firstName = JOptionPane.showInputDialog("Enter your first name:");
    if (firstName == null || firstName.isEmpty()) {
        JOptionPane.showMessageDialog(null, "First name is required.");
        return;
    }

    String lastName = JOptionPane.showInputDialog("Enter your last name:");
    if (lastName == null || lastName.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Last name is required.");
        return;
    }

    String username = "";
    boolean validUsername = false;
    while (!validUsername) {
        username = JOptionPane.showInputDialog("Enter a username (must contain an underscore and no more than 5 characters):");
        if (username == null) return; // Exit if user cancels
        if (username.contains("_") && username.length() <= 5) {
            validUsername = true;
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
        }
    }
    usernames.add(username);
    JOptionPane.showMessageDialog(null, "Username successfully captured.");

    String password = "";
    boolean validPassword = false;
    while (!validPassword) {
        password = JOptionPane.showInputDialog("Enter a password (must contain at least 8 characters, a capital letter, a number, and a special character):");
        if (password == null) return; // Exit if user cancels
        if (isPasswordValid(password)) {
            validPassword = true;
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }
    }
    passwords.add(password);
    JOptionPane.showMessageDialog(null, "Password successfully captured.");

    firstNames.add(firstName);
    lastNames.add(lastName);

    JOptionPane.showMessageDialog(null, "Registration success");
}


    /**
     * Validates password format.
     * 
     * @param password Password to be validated
     * @return true if password meets the complexity requirements, false otherwise
     */
    private static boolean isPasswordValid(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&   // At least one capital letter
                password.matches(".*\\d.*") &&      // At least one number
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"); // At least one special character
    }

    /**
     * Handles user login.
     * 
     * @return true if login is successful, false otherwise
     */
  private static boolean loginUser() {
    if (usernames.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please Register user before logging in.");
        return false;
    }

    int attempts = 0;
    boolean authenticated = false;

    while (attempts < 3 && !authenticated) {
        String username = JOptionPane.showInputDialog("Enter your username:");
        if (username == null) return false; // Exit if user cancels

        String password = JOptionPane.showInputDialog("Enter your password:");
        if (password == null) return false; // Exit if user cancels

        // Check if the entered username and password are correct
        for (int i = 0; i < usernames.size(); i++) {
            if (usernames.get(i).equals(username) && passwords.get(i).equals(password)) {
                // Correctly display first and last names without brackets
                String welcomeMessage = "Welcome, " + firstNames.get(i) + " " + lastNames.get(i) + " it is great to see you again!";
                JOptionPane.showMessageDialog(null, welcomeMessage);
                
                // Display the "Welcome to EasyKanban" message
                JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

                // Authentication successful
                authenticated = true;
                break;
            }
        }

        if (!authenticated) {
            attempts++;
            if (attempts < 3) {
                JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again. You have " + (3 - attempts) + " attempts left.");
            } else {
                JOptionPane.showMessageDialog(null, "You have exceeded the maximum attempts. Please wait for 1 minute before trying again.");
                // Lock the user out for 1 minute
                lockOutUser();
            }
        }
    }

    return authenticated;
}


/**
 * Locks the user out for 1 minute.
 */
private static void lockOutUser() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            JOptionPane.showMessageDialog(null, "You can now try logging in again.");
        }
    }, 60000); // Lock out for 1 minute (60000 milliseconds)
}

    /**
     * Runs the main application after successful login.
     */
    private static void runMainApplication() {
    boolean running = true;
    while (running) {
        String menu = """
            Main Menu:
            1. Add Task
            2. Display Tasks with Status 'Done'
            3. Display Longest Task Duration
            4. Search Task by Name
            5. Search Tasks by Developer
            6. Delete Task by Name
            7. Display All Tasks
            8. Show Report
            9. Exit
            Enter your choice:
            """;

        String choiceString = JOptionPane.showInputDialog(menu);
        if (choiceString == null) break; // Exit if user cancels

        // Validate that the input is a valid number
        int choice;
        try {
            choice = Integer.parseInt(choiceString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a valid option.");
            continue; // Prompt the user again for input
        }

        switch (choice) {
            case 1 -> addTask();
            case 2 -> displayTasksWithStatusDone();
            case 3 -> displayLongestTask();
            case 4 -> searchTaskByName();
            case 5 -> searchTasksByDeveloper();
            case 6 -> deleteTaskByName();
            case 7 -> displayAllTasks();
            case 8 -> JOptionPane.showMessageDialog(null, "Coming Soon!");
            case 9 -> running = false;
            default -> JOptionPane.showMessageDialog(null, "Invalid input, please enter a valid option.");
        }
    }

    JOptionPane.showMessageDialog(null, "Exiting... Goodbye!");
}

    // Task-related methods (unchanged from previous version)
   private static void addTask() {
    String developer = JOptionPane.showInputDialog("Enter Developer Name:");
    if (developer == null) return;
    developers.add(developer);

    String taskName = JOptionPane.showInputDialog("Enter Task Name:");
    if (taskName == null) return;
    taskNames.add(taskName);

    String taskID = generateTaskID(taskName, developers.size() - 1);
    taskIDs.add(taskID);

    String durationString = JOptionPane.showInputDialog("Enter Task Duration (in hours):");
    if (durationString == null) return;
    int taskDuration = Integer.parseInt(durationString);
    taskDurations.add(taskDuration);

    String taskStatus = "";
    boolean validStatus = false;
    while (!validStatus) {
        String statusInput = JOptionPane.showInputDialog("""
                Enter Task Status:
                1. To Do
                2. Doing
                3. Done
                """);
        if (statusInput == null) return;
        int statusChoice;
        try {
            statusChoice = Integer.parseInt(statusInput);
            switch (statusChoice) {
                case 1 -> {
                    taskStatus = "To Do";
                    validStatus = true;
                }
                case 2 -> {
                    taskStatus = "Doing";
                    validStatus = true;
                }
                case 3 -> {
                    taskStatus = "Done";
                    validStatus = true;
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option. Please select 1, 2, or 3.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input, please enter a valid number (1, 2, or 3).");
        }
    }
    taskStatuses.add(taskStatus);

    String taskDescription = "";
    boolean validDescription = false;
    while (!validDescription) {
        taskDescription = JOptionPane.showInputDialog("Enter Task Description (less than 50 characters):");
        if (taskDescription == null) return;
        if (taskDescription.length() < 50) {
            validDescription = true;
            JOptionPane.showMessageDialog(null, "Task Successfully Captured.");
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
        }
    }
}

    private static String generateTaskID(String taskName, int index) {
        String prefix = taskName.length() > 2 ? taskName.substring(0, 2).toUpperCase() : taskName.toUpperCase();
        return prefix + ":" + index;
    }

    private static void displayTasksWithStatusDone() {
        StringBuilder result = new StringBuilder("Tasks with Status 'Done':\n");
        for (int i = 0; i < taskStatuses.size(); i++) {
            if (taskStatuses.get(i).equalsIgnoreCase("Done")) {
                result.append("Developer: ").append(developers.get(i))
                        .append(", Task Name: ").append(taskNames.get(i))
                        .append(", Task Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }
        JOptionPane.showMessageDialog(null, result.toString());
    }

    private static void displayLongestTask() {
        if (taskDurations.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        int maxIndex = 0;
        for (int i = 1; i < taskDurations.size(); i++) {
            if (taskDurations.get(i) > taskDurations.get(maxIndex)) {
                maxIndex = i;
            }
        }

        String result = "Task with Longest Duration:\n" +
                "Developer: " + developers.get(maxIndex) +
                ", Task Name: " + taskNames.get(maxIndex) +
                ", Duration: " + taskDurations.get(maxIndex) + " hours";
        JOptionPane.showMessageDialog(null, result);
    }

    private static void searchTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to Search:");
        if (taskName == null) return;

        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                String result = "Task Found:\n" +
                        "Task Name: " + taskNames.get(i) +
                        ", Developer: " + developers.get(i) +
                        ", Status: " + taskStatuses.get(i) +
                        ", Duration: " + taskDurations.get(i) + " hours";
                JOptionPane.showMessageDialog(null, result);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void searchTasksByDeveloper() {
        String developerName = JOptionPane.showInputDialog("Enter Developer Name to Search Tasks:");
        if (developerName == null) return;

        StringBuilder result = new StringBuilder("Tasks by " + developerName + ":\n");
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).equalsIgnoreCase(developerName)) {
                result.append("Task Name: ").append(taskNames.get(i))
                        .append(", Status: ").append(taskStatuses.get(i))
                        .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
            }
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }

    private static void deleteTaskByName() {
        String taskName = JOptionPane.showInputDialog("Enter Task Name to Delete:");
        if (taskName == null) return;

        for (int i = 0; i < taskNames.size(); i++) {
            if (taskNames.get(i).equalsIgnoreCase(taskName)) {
                developers.remove(i);
                taskNames.remove(i);
                taskIDs.remove(i);
                taskDurations.remove(i);
                taskStatuses.remove(i);
                JOptionPane.showMessageDialog(null, "Task Deleted Successfully.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Task not found.");
    }

    private static void displayAllTasks() {
        if (taskNames.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return;
        }

        StringBuilder result = new StringBuilder("All Tasks:\n");
        for (int i = 0; i < taskNames.size(); i++) {
            result.append("Task ID: ").append(taskIDs.get(i))
                    .append(", Developer: ").append(developers.get(i))
                    .append(", Task Name: ").append(taskNames.get(i))
                    .append(", Status: ").append(taskStatuses.get(i))
                    .append(", Duration: ").append(taskDurations.get(i)).append(" hours\n");
        }

        JOptionPane.showMessageDialog(null, result.toString());
    }
}