package com.iTexus.logic;

import com.iTexus.entity.User;

import java.util.List;

public interface UsersLogic {
    void update(User n, Integer id) throws LogicException;

    void add(String name, String lastname, String email, List<String> phoneNumbers, List<String> roles)
            throws LogicException;

    User deleteById(int id) throws LogicException;

    List<User> allNotes() throws LogicException;

    List<User> find(String text) throws LogicException;
}
