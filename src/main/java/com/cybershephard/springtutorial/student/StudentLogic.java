package com.cybershephard.springtutorial.student;

import java.util.Optional;

public class StudentLogic {



    /**
     * Validates the new name plus validates against previous one
     * @param oldName
     * @param name
     * @return
     */
    public static boolean validateName(String oldName, String name){
        if(!validateNonNullableValue(name) || name.equals(oldName)) return false;
        return true;
    }

    /**
     * Validates the potential value
     * @param input
     * @return
     */
    public static boolean validateNonNullableValue(String input){
        if(input.equals(null) || input.length() == 0) return false;
        return true;
    }

    /**
     * Validates the new email plus validates against previous one
     * @param oldEmail
     * @param email
     * @return
     */
    public static boolean validateEmail(String oldEmail, String email){
        if(!validateNonNullableValue(email) || email.equals(oldEmail))  return false;
        return true;
    }
}
