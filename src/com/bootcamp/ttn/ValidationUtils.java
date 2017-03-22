package com.bootcamp.ttn;

import java.util.regex.Pattern;

public class ValidationUtils {
    public static boolean authenticateID(User user, String id, String password){
        if(Pattern.matches("\\d{6}",id)){
            if(id.equals(user.getId())){
                if(password.equals(user.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }
}
