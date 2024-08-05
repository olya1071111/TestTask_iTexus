package com.iTexus.controller;

import com.iTexus.entity.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.iTexus.util.ValidateEmail.checkValidateEmail;
import static com.iTexus.util.ValidatePhoneNumber.checkValidatePhoneNumber;

public class MenuForAddOrApdateUser {

    private MenuForAddOrApdateUser() {
    }

    public static User DataForAddOrUpdateUser() {

        User newUser = new User();

        BufferedReader numIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter the first name (Ex. Ivan) --> ");

        boolean isCorrectName = false;
        while (isCorrectName == false) {
            String name = null;
            try {
                name = numIn.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Pattern pattern = Pattern.compile("[A-ZА-Я]{1}[a-zа-я]{1,}");
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                newUser.setName(name);
                isCorrectName = true;
            } else {
                System.out.println("\nName must consist of letters, and begin with a capital letter.Try again.");
                continue;
            }
        }

        System.out.print("Enter the lastname (Ex.Ivanov) --> ");
        boolean isCorrectLasName = false;
        while (isCorrectLasName == false) {
            String lastname;
            try {
                lastname = numIn.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Pattern pattern = Pattern.compile("[A-ZА-Я]{1}[a-zа-я]{1,}");
            Matcher matcher = pattern.matcher(lastname);
            if (matcher.matches()) {
                newUser.setLastName(lastname);
                isCorrectLasName = true;
            } else {
                System.out.println("\n Surname must consist of letters, and begin with a capital letter.Try again.");
                continue;
            }
        }

        System.out.print("Enter email --> ");
        boolean isCorrectEmail = false;

        while (isCorrectEmail == false) {
            String email;
            try {
                email = numIn.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (checkValidateEmail(email)) {
                newUser.setEmail(email);
                isCorrectEmail = true;
            } else {
                System.out.println("\nNot correct email. Example '****@****.***' .Try again.");
                continue;
            }
        }

        Boolean isCorrectPhoneNumber = false;
        int PhoneNumber = 0;
        List<String> numbers = new ArrayList<>();

        while (isCorrectPhoneNumber == false || PhoneNumber < 3) {
            System.out.print("Enter telephone number (375** *******) --> ");
            String telNumber = null;


            try {
                telNumber = numIn.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (checkValidatePhoneNumber(telNumber)) {
                numbers.add(telNumber);
                isCorrectPhoneNumber = true;
                PhoneNumber++;

            } else {
                System.out.println("\nYou entered the phone number incorrectly. Check that after the code there is a space 375 ** space *******.Try again . ");
                continue;
            }
            if (PhoneNumber < 3) {
                System.out.print("\nYou can enter " + (3 - PhoneNumber) + " more numbers. Choose Y/N --> ");
                String unswer = null;
                try {
                    unswer = numIn.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (unswer.equals("Y") && PhoneNumber < 3) {
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }

        }
        newUser.setPhoneNumbers(numbers);

        boolean isCorrectRole = false;
        int rolesAdded = 0;
        List<String> roles = new ArrayList<>();
        while (isCorrectRole == false || rolesAdded < 3) {
            System.out.print("Enter role --> ");
            try {
                String role = numIn.readLine();
                roles.add(role);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            isCorrectRole = true;
            rolesAdded++;
            if (rolesAdded < 3) {
                System.out.print("\nYou can add " + (3 - rolesAdded) + " role? Choose Y/N  --> ");
                String answer = null;
                try {
                    answer = numIn.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (answer.equals("Y")) {
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        newUser.setRoles(roles);
        return newUser;
    }
}
