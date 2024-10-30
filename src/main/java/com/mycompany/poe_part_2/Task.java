/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part_2;

/**
 * Represents a task with its details and functionalities.
 * This class contains attributes and methods to manage task information.
 * 
 * @author Dawood
 */
public class Task {
    // Attributes of the Task class
    private String taskDescription;   // Description of the task
    private String taskName;          // Name of the task
    private String developerDetails;   // Details of the developer assigned to the task
    private int taskDuration;          // Duration of the task in hours
    private String taskStatus;         // Current status of the task (e.g., Pending, Completed)
    private String taskID;             // Unique identifier for the task
    private int taskNumber;            // Sequential number assigned to the task

    // Constructor to initialize the Task object
    public Task(String taskDescription, String taskName, String developerDetails, int taskDuration, int taskNumber) {
        this.taskDescription = taskDescription; // Set task description
        this.taskName = taskName;               // Set task name
        this.developerDetails = developerDetails; // Set developer details
        this.taskDuration = taskDuration;       // Set task duration
        this.taskNumber = taskNumber;           // Initialize task number
    }

    // Getter and Setter for taskDescription
    public String getTaskDescription() {
        return taskDescription; // Return the task description
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription; // Set a new task description
    }

    // Getter and Setter for taskName
    public String getTaskName() {
        return taskName; // Return the task name
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName; // Set a new task name
    }

    // Getter and Setter for developerDetails
    public String getDeveloperDetails() {
        return developerDetails; // Return developer details
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails; // Set new developer details
    }

    // Getter and Setter for taskDuration
    public int getTaskDuration() {
        return taskDuration; // Return task duration
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration; // Set a new task duration
    }

    // Method to check if the task description exceeds 50 characters
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50; // Return true if the description is valid
    }

    // Method to create a unique Task ID based on taskName and developerDetails
    public String createTaskID(int taskNumber) {
        String taskInitials = taskName.substring(0, 2).toUpperCase(); // Get initials from task name
        String developerInitials = developerDetails.substring(developerDetails.length() - 3).toUpperCase(); // Get initials from developer details
        return taskInitials + ":" + taskNumber + ":" + developerInitials; // Format and return the Task ID
    }

    // Method to return the total hours required for the task
    public int returnTotalHours() {
        return this.taskDuration; // Return the task duration as total hours
    }

    // Setters for task status and task ID
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus; // Set the current status of the task
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID; // Set the unique Task ID
    }

    // Set Task Number
    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber; // Set the task number directly as an int
    }

    // Method to display all task details in a formatted string
    public String printTaskDetails() {
        return "Task Name: " + taskName + "\n" + // Print task name
               "Task Number: " + taskNumber + "\n" + // Print task number
               "Description: " + taskDescription + "\n" + // Print task description
               "Developer: " + developerDetails + "\n" + // Print developer details
               "Duration: " + taskDuration + " hours\n" + // Print task duration
               "Task ID: " + taskID + "\n" + // Print task ID
               "Task Status: " + taskStatus + "\n"; // Print task status
    }
}
