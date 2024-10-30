/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe_part_2;
import java.util.regex.Pattern;

/**
 * Manages user login and registration functionalities.
 * This class includes methods for validating username and password criteria.
 * 
 * @author Dawood
 */
public class LoginClass {
    
    // Constants for validation
    private static final int MAX_USERNAME_LENGTH = 5; // Maximum allowed length for username
    private static final int MIN_PASSWORD_LENGTH = 8; // Minimum required length for password
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$"; // Regex pattern for password complexity

    // User registration details
    private String registeredfirstName; // Stores the first name of the registered user
    private String registerlastName;    // Stores the last name of the registered user
    private String registeredUsername;   // Stores the username of the registered user
    private String registeredPassword;   // Stores the password of the registered user

    /**
     * Registers a new user with the provided details.
     * Performs validation on the username and password.
     * 
     * @param firstName The first name of the user.
     * @param lastName The last name of the user.
     * @param username The username chosen by the user.
     * @param password The password chosen by the user.
     * @return A message indicating the success or failure of the registration.
     */
    public String registerUser(String firstName, String lastName, String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length."; // Error message for username validation
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure the password contains at least 8 characters, a capital letter, a number and a special character."; // Error message for password validation
        }
        // Assuming registration is successful:
        return "Welcome to EasyKanBan"; // Success message upon successful registration
    }
    
    /**
     * Checks if the username meets the specified formatting criteria.
     * 
     * @param username The username to validate.
     * @return true if the username is valid, false otherwise.
     */
    public boolean checkUserName(String username) {
        // Implement the logic to check if the username is correctly formatted.
        return username.length() <= MAX_USERNAME_LENGTH && username.contains("_"); // Ensure username has underscore and length constraints
    }

    /**
     * Validates the password based on complexity requirements.
     * 
     * @param password The password to validate.
     * @return true if the password meets complexity criteria, false otherwise.
     */
    public boolean checkPasswordComplexity(String password) {
        // Implement the logic to check password complexity.
        return password.length() >= MIN_PASSWORD_LENGTH && // Ensure password is of minimum length
               password.matches(".*[A-Z].*") && // Ensure password contains at least one uppercase letter
               password.matches(".*[0-9].*") && // Ensure password contains at least one digit
               password.matches(".*[^a-zA-Z0-9].*"); // Ensure password contains at least one special character
    }

    /**
     * Logs in the user with the provided credentials.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if login is successful, false otherwise.
     */
    public boolean loginUser(String username, String password) {
        // Implement the login logic here.
        // Assuming successful login for demonstration:
        return true; // Change this to your actual logic
    }
}
