package com.learning.utils;

public class AppUtils {

    public static boolean isValidString(String sText) {

        if (sText == null || sText.trim().isEmpty()) {
            return false;
        }


        return true;
    }

}
