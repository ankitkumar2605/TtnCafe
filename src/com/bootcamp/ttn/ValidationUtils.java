package com.bootcamp.ttn;

import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean authenticateID(User user, String name, String password){

        if(name.indexOf('@')!=-1) {

            if(Pattern.matches("[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z0-9]{3}",name)) {

                if(ValidationUtils.isPasswordValid(password))
                {
                    System.out.println("User Logged in...");
                    return true;
                }
                else {
                    System.out.println("Please enter correct password");
                    return false;
                }

            }
            else {
                System.out.println("Please enter valid username or emailid");
                return false;
            }

        }

        else if(Pattern.matches("[[a-zA-Z]+[0-9]]{6,15}",name)) {

            if(ValidationUtils.isPasswordValid(password))
            {
                System.out.println("User Logged in...");
                return true;
            }
            else {
                System.out.println("Please enter correct password");
                return false;
            }

        }

        else
            System.out.println("Please enter valid username or emailid");
        return false;
    }

    public static boolean isPasswordValid(String password) {
        return Pattern.matches("^[a-zA-Z0-9_]{7,}$", password);
    }

}
