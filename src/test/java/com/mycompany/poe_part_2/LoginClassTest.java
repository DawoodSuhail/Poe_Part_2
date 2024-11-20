/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part_2;

import com.mycompany.poe_part_2.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

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
    }