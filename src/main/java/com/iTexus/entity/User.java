package com.iTexus.entity;

import com.iTexus.util.GenerateId;

import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String lastName;
    private List<String> phoneNumbers;
    private String email;
    private List<String> roles;

    public User() {

    }

    public User(Integer id, String name, String lastName, String email, List<String> phoneNumbers, List<String> roles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.roles = roles;
    }

    public User(String name, String lastName, String email, List<String> phoneNumbers, List<String> roles) {
        this.id = GenerateId.nextId();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Id: " + id + " Name: " + name + " LastName: " + lastName + " Email: " + email +
                " PhoneNumbers: " + phoneNumbers.toString() + " Roles: " + roles.toString();
    }
}
