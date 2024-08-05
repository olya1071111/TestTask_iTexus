package com.iTexus.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {

    private ValidateEmail() {
    }

    public static boolean checkValidateEmail(String email) {
        Pattern pattern = Pattern.compile("([a-zA-Z_0-9]{1,})+@([a-zA-Z_0-9]{1,}+\\.[a-z]{2,4})");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
