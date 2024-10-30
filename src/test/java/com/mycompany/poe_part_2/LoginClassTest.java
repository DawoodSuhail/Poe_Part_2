/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part_2;

import com.mycompany.poe_part_2.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dawood
 */
public class LoginClassTest {

      // Test of checkUserName method, of class LoginClass.
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "Suha_";
        LoginClass instance = new LoginClass();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkPasswordComplexity method, of class LoginClass.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "Suhail$17";
        LoginClass instance = new LoginClass();
        boolean expResult = true; // Password meets the complexity requirements
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class LoginClass.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String firstName = "Suhail";
        String lastName = "Dawood";
        String username = "Suha_";
        String password = "Suhail$17";
        LoginClass instance = new LoginClass();
        String expResult = "Registration successful!";
        String result = instance.registerUser(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of loginUser method, of class LoginClass.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "Suha_";
        String password = "Suhail$17";
        LoginClass instance = new LoginClass();
        instance.registerUser("Suhail", "Dawood", username, password); // Register user first
        boolean expResult = true; // Expect login to succeed
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class LoginClass.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = true; // Set to true for successful login
        LoginClass instance = new LoginClass();
        String expResult = "Welcome Suhail Dawood it is great to see you again.";
        String result = instance.returnLoginStatus(loginSuccess);
        assertEquals(expResult, result);

        loginSuccess = false; // Set to false for failed login
        expResult = "Username or password incorrect, please try again.";
        result = instance.returnLoginStatus(loginSuccess);
        assertEquals(expResult, result);
    }
    
    // Test Task description check (Success)
    @Test
    public void testCheckTaskDescriptionSuccess() {
        Task task = new Task();
        task.taskDescription = "Create Login to authenticate users"; // Less than 50 characters
        assertTrue(task.checkTaskDescription(), "Task description should be valid");
    }

    // Test Task description check (Failure)
    @Test
    public void testCheckTaskDescriptionFailure() {
        Task task = new Task();
        task.taskDescription = "This task description exceeds fifty characters so it should fail"; // More than 50 characters
        assertFalse(task.checkTaskDescription(), "Task description should be invalid");
    }
    
    // Test createTaskID method of Task class
    @Test
    public void testCreateTaskID() {
        Task task1 = new Task();
        task1.taskName = "Login Feature";
        task1.developerDetails = "Robyn Harrison";
        assertEquals("LF:0:SON", task1.createTaskID(0), "TaskID generation for Task 1 failed.");

        Task task2 = new Task();
        task2.taskName = "Add Task Feature";
        task2.developerDetails = "Mike Smith";
        assertEquals("AT:1:TH", task2.createTaskID(1), "TaskID generation for Task 2 failed.");
    }

    // Test total hours for two tasks
    @Test
    public void testTotalHoursForTwoTasks() {
        Task task1 = new Task();
        task1.taskDuration = 8; // Task 1 duration

        Task task2 = new Task();
        task2.taskDuration = 10; // Task 2 duration

        int totalHours = task1.returnTotalHours() + task2.returnTotalHours();
        assertEquals(18, totalHours, "Total hours for two tasks should be 18.");
    }

    // Test total hours for five tasks
    @Test
    public void testTotalHoursForFiveTasks() {
        Task[] tasks = new Task[5];

        tasks[0] = new Task();
        tasks[0].taskDuration = 10;

        tasks[1] = new Task();
        tasks[1].taskDuration = 12;

        tasks[2] = new Task();
        tasks[2].taskDuration = 55;

        tasks[3] = new Task();
        tasks[3].taskDuration = 11;

        tasks[4] = new Task();
        tasks[4].taskDuration = 1;

        int totalHours = 0;
        for (Task task : tasks) {
            totalHours += task.returnTotalHours();
        }
        assertEquals(89, totalHours, "Total hours for five tasks should be 89.");
    }

    // Test TaskID generation in a loop
    @Test
    public void testTaskIDLoop() {
        String[] expectedIDs = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "CR:3:ND"};
        Task[] tasks = new Task[4];

        tasks[0] = new Task();
        tasks[0].taskName = "Create";
        tasks[0].developerDetails = "Mike";

        tasks[1] = new Task();
        tasks[1].taskName = "Create";
        tasks[1].developerDetails = "Richard";

        tasks[2] = new Task();
        tasks[2].taskName = "Create";
        tasks[2].developerDetails = "Nathan";

        tasks[3] = new Task();
        tasks[3].taskName = "Create";
        tasks[3].developerDetails = "Land";

        for (int i = 0; i < tasks.length; i++) {
            assertEquals(expectedIDs[i], tasks[i].createTaskID(i), "TaskID generation for task " + (i + 1) + " failed.");
        }
    }
}