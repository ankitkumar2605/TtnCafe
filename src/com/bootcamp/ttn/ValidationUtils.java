package com.bootcamp.ttn;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isValidUser(String userEmail, String userId, String userPassword) {

        if (isUserIdValid(userId)) {

            if (isValidEmail(userEmail)) {

                if (isPasswordValid(userPassword)) {
                    return true;
                } else {
                    System.out.println("Please enter correct password");
                }
            } else {
                System.out.println("Please enter valid username or emailid");
            }
        } else {
            System.out.println("Please enter valid userId");
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        return Pattern.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z0-9]{3}", email);
    }

    public static boolean isPasswordValid(String password) {
        return Pattern.matches("^[a-zA-Z0-9_]{7,}$", password);
    }

    public static boolean isUserIdValid(String userId) {
        return Pattern.matches("[\\d]{7}", userId);
    }

    public static boolean authenticateCredentials(String adminEmail, String adminPassword, String email, String password) {
        try{
            if (adminEmail.equals(email)) {
                if (adminPassword.equals(password)) {
                    return true;
                }
            }throw new InvalidUserException("Invalid User Credentials!!!!!!");
        }catch (InvalidUserException iUE){
            return false;
        }
    }
}
