/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poe_part_2;
import java.util.Scanner;

/**
 *
 * @author Dawood
 */
public class Poe_Part_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginClass login = new LoginClass(); // Create an instance of LoginClass

        // Variables to store user input
        String firstName;
        String lastName;
        String username;
        String password;
        
        // Register the user (first name and last name will be part of the registration)
        do {
            System.out.print("Enter first name: ");
            firstName = sc.nextLine();
            if (firstName.isEmpty()) {
                System.out.println("First name cannot be empty.");
            } else {
                System.out.println("First name successfully captured.");
            }
        } while (firstName.isEmpty());

        do {
            System.out.print("Enter last name: ");
            lastName = sc.nextLine();
            if (lastName.isEmpty()) {
                System.out.println("Last name cannot be empty.");
            } else {
                System.out.println("Last name successfully captured.");
            }
        } while (lastName.isEmpty());

        // Collect username and check with login.checkUserName() method
        do {
            System.out.print("Enter username: ");
            username = sc.nextLine();
            if (!login.checkUserName(username)) {
                System.out.println("Username is not correctly formatted, please ensure it contains an underscore and is no more than 5 characters.");
            } else {
                System.out.println("Username successfully captured.");
            }
        } while (!login.checkUserName(username));

        // Collect password and check with login.checkPasswordComplexity() method
        do {
            System.out.print("Enter password: ");
            password = sc.nextLine();
            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted. Ensure it contains at least 8 characters, a capital letter, a number, and a special character.");
            } else {
                System.out.println("Password successfully captured.");
            }
        } while (!login.checkPasswordComplexity(password));

        // Register the user using the registerUser method from LoginClass
        String registrationStatus = login.registerUser(username, password);
        System.out.println(registrationStatus);

        // Confirmation of captured information
        String confirmation;
        do {
            System.out.println("\nPlease confirm your details:");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password.replaceAll(".", "*")); // Hide password
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.print("Are these details correct? (yes/no): ");
            confirmation = sc.nextLine().trim().toLowerCase();

            if (confirmation.equals("no")) {
                System.out.println("Let's re-enter your details.");

                // Re-enter details if the user confirms no
                do {
                    System.out.print("Enter first name: ");
                    firstName = sc.nextLine();
                } while (firstName.isEmpty());

                do {
                    System.out.print("Enter last name: ");
                    lastName = sc.nextLine();
                } while (lastName.isEmpty());

                do {
                    System.out.print("Enter username: ");
                    username = sc.nextLine();
                } while (!login.checkUserName(username));

                do {
                    System.out.print("Enter password: ");
                    password = sc.nextLine();
                } while (!login.checkPasswordComplexity(password));
                
                registrationStatus = login.registerUser(username, password);
                System.out.println(registrationStatus);
            }
        } while (!confirmation.equals("yes"));
        
        
    }
}
