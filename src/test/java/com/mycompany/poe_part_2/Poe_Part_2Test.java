/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poe_part_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Dawood
 */
public class Poe_Part_2Test {
    
    public Poe_Part_2Test() {
    }
    
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
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
    }

    /**
     * Test of registerUser method, of class LoginClass.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "Suha_";
        String password = "Suhail$17";
        LoginClass instance = new LoginClass();
        String expResult = "Registration successful";
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
        boolean expResult = false;
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnLoginStatus method, of class LoginClass.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginSuccess = false;
        LoginClass instance = new LoginClass();
        String expResult = "Username or password incorrect, please try again.";
        String result = instance.returnLoginStatus(loginSuccess);
        assertEquals(expResult, result);
    }
}
