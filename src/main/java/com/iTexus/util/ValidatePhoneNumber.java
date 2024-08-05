package com.iTexus.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    private ValidatePhoneNumber() {
    }

    public static boolean checkValidatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("375[0-9]{2}[\\s][0-9]{7}");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
