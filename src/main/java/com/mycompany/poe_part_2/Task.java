/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part_2;

/**
 *
 * @author Dawood
 */
public class Task {
     String taskName;
    String developerDetails;
    String taskDescription;
    int taskDuration;
    String taskID;
    String taskStatus;

    // Check if task description is under 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Create TaskID
    public String createTaskID(int taskNumber) {
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String devInitials = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskInitials + ":" + taskNumber + ":" + devInitials;
    }

    // Print task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer: " + developerDetails + "\n" +
               "Task Number: " + taskID.split(":")[1] + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }

    // Return total hours for the task
    public int returnTotalHours() {
        return taskDuration;
    }
}
