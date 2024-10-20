/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;
import java.util.regex.Pattern;

/**
 *
 * @author Dawood
 */
public class LoginClass {
    // Constants for validation
    private static final int MAX_USERNAME_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

    private String registeredfirstName;
    private String registerlastName;
    private String registeredUsername;
    private String registeredPassword;

    //The method to check the username if it has the required format (underscore and is no more than 5 characters in lenght)
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= MAX_USERNAME_LENGTH;
    }

    public boolean checkPasswordComplexity(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        return password.length() >= MIN_PASSWORD_LENGTH && pattern.matcher(password).matches();
    }

    public String registerUser(String username, String password) {
        if (!checkUserName(username)  || !checkPasswordComplexity(password) ) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        String firstname = null; //added in
        String lastname = null; //added in
       // if (!checkPasswordComplexity(password)) {
        //    return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
       // }
        this.registeredfirstName = firstname;  //added in
        this.registerlastName = lastname; //added in
        this.registeredUsername = username;
        this.registeredPassword = password;
        return "Registration successful!";
    }

    public boolean loginUser(String username, String password) {
        return username.equals(registeredUsername) && password.equals(registeredPassword);
    }

    public String returnLoginStatus(boolean loginSuccess) {
        return loginSuccess ? "Welcome! It is great to see you again." : "Username or password incorrect, please try again.";
    }
}