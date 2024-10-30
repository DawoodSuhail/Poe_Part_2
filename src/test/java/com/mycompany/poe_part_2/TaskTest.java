/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part_2;

import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.poe_part_2.Task;

/**
 *
 * @author Dawood
 */
public class TaskTest {
    
    public TaskTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserName method, of class LoginClass.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        LoginClass instance = new LoginClass();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class LoginClass.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = true; // Change based on the test case
        LoginClass instance = new LoginClass();
        String expResult = "Login successful."; // Adjust expected value based on logic
        String result = instance.returnLoginStatus(loginSuccess);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkUserName method for correctly formatted username.
     */
    @Test
    public void testUsernameCorrectlyFormatted() {
        System.out.println("Testing correctly formatted username");
        String username = "kyl_1"; // Valid username
        LoginClass instance = new LoginClass();
        boolean result = instance.checkUserName(username);
        assertTrue(result, "Username should be correctly formatted.");
    }

    /**
     * Test of checkUserName method for incorrectly formatted username.
     */
    @Test
    public void testUsernameIncorrectlyFormatted() {
        System.out.println("Testing incorrectly formatted username");
        String username = "kyle!!!!!!!"; // Invalid username
        LoginClass instance = new LoginClass();
        boolean result = instance.checkUserName(username);
        assertFalse(result, "Username should be incorrectly formatted.");
    }

    /**
     * Test of checkPasswordComplexity method for valid password.
     */
    @Test
    public void testPasswordComplexityMeetsRequirements() {
        System.out.println("Testing password complexity requirements");
        String password = "Ch&&sec@ke99!"; // Valid password
        LoginClass instance = new LoginClass();
        boolean result = instance.checkPasswordComplexity(password);
        assertTrue(result, "Password should meet complexity requirements.");
    }

    /**
     * Test of checkPasswordComplexity method for invalid password.
     */
    @Test
    public void testPasswordComplexityDoesNotMeetRequirements() {
        System.out.println("Testing password complexity does not meet requirements");
        String password = "password"; // Invalid password
        LoginClass instance = new LoginClass();
        boolean result = instance.checkPasswordComplexity(password);
        assertFalse(result, "Password should not meet complexity requirements.");
    }

    /**
     * Test of registerUser method for a successful registration.
     */
    @Test
    public void testSuccessfulRegistration() {
        System.out.println("Testing successful registration");
        String firstName = "Kyle";
        String lastName = "Johnson";
        String username = "kyl_1"; // Valid username
        String password = "Ch&&sec@ke99!"; // Valid password
        LoginClass instance = new LoginClass();
        String result = instance.registerUser(username, password);
        String expected = "Welcome " + firstName + " " + lastName + ". It is great to see you.";
        assertEquals(expected, result, "Registration should succeed with a valid username and password.");
    }

    /**
     * Test of registerUser method for invalid username.
     */
    @Test
    public void testInvalidUsername() {
        System.out.println("Testing invalid username");
        String firstName = "Kyle";
        String lastName = "Johnson";
        String username = "kyle!!!!!!!"; // Invalid username
        String password = "Ch&&sec@ke99!"; // Valid password
        LoginClass instance = new LoginClass();
        String result = instance.registerUser(username, password);
        String expected = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        assertEquals(expected, result, "Registration should fail with an invalid username.");
    }

    /**
     * Test of registerUser method for invalid password.
     */
    @Test
    public void testInvalidPassword() {
        System.out.println("Testing invalid password");
        String firstName = "Kyle";
        String lastName = "Johnson";
        String username = "kyl_1"; // Valid username
        String password = "password"; // Invalid password
        LoginClass instance = new LoginClass();
        String result = instance.registerUser(username, password);
        String expected = "Password is not correctly formatted, please ensure the password contains at least 8 characters, a capital letter, a number and a special character.";
        assertEquals(expected, result, "Registration should fail with an invalid password.");
    }

    /**
     * Test of loginUser method for successful login.
     */
    @Test
    public void testLoginSuccess() {
        System.out.println("Testing successful login");
        String username = "kyl_1"; // Valid username
        String password = "Ch&&sec@ke99!"; // Valid password
        LoginClass instance = new LoginClass();
        instance.registerUser("Kyle", "Johnson", username, password); // Register the user first
        boolean result = instance.loginUser(username, password);
        assertTrue(result, "Login should be successful with correct credentials.");
    }

    /**
     * Test of loginUser method for failed login.
     */
    @Test
    public void testLoginFailure() {
        System.out.println("Testing failed login");
        String username = "kyl_1"; // Valid username
        String password = "wrongPassword"; // Invalid password
        LoginClass instance = new LoginClass();
        boolean result = instance.loginUser(username, password);
        assertFalse(result, "Login should fail with incorrect credentials.");
    }
}
