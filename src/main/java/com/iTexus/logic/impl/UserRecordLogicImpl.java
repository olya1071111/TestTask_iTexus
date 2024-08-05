package com.iTexus.logic.impl;

import com.iTexus.logic.LogicException;
import com.iTexus.logic.UsersLogic;
import com.iTexus.dao.DaoException;
import com.iTexus.dao.DaoProvider;
import com.iTexus.dao.UsersDao;
import com.iTexus.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Business logic layer: implementation of the basic commands for the operation of the application
 */

public class UserRecordLogicImpl implements UsersLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final UsersDao dao = provider.getUsersDao();

    @Override
    public void update(User n, Integer id) throws LogicException {
        List<User> allNotes;
        try {

            allNotes = dao.allNotes();

            for (User note : allNotes) {
                if (note.getId().equals(id)) {
                    note.setName(n.getName());
                    note.setLastName(n.getLastName());
                    note.setEmail(n.getEmail());
                    note.setPhoneNumbers(n.getPhoneNumbers());
                    note.setRoles(n.getRoles());
                }
            }
            dao.update(allNotes);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public void add(String name, String lastname, String email, List<String> phoneNumbers, List<String> roles)
            throws LogicException {

        User n = new User(name, lastname, email, phoneNumbers, roles);

        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    public User findById(int id) throws LogicException {

        List<User> myUser = allNotes();

        for (User n : myUser) {
            if (n.getId() == id) {
                return n;
            }
        }
        throw new LogicException("Not found by given id!");
    }

    private boolean isIdExist(int id) throws LogicException {
        User n = findById(id);
        return n != null;
    }

    @Override
    public User deleteById(int id) throws LogicException {

        try {
            isIdExist(id);
        } catch (LogicException e) {
            throw new LogicException(e);
        }

        User deletedUser;
        try {
            deletedUser = dao.deleteById(id);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
        return deletedUser;
    }

    @Override
    public List<User> find(String text) throws LogicException {
        List<User> result = new ArrayList<>();

        List<User> users;
        try {
            users = dao.allNotes();

            for (User n : users) {
                if (isTextInNote(n, text)) {
                    result.add(n);
                }
            }
            return result;

        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    private boolean isTextInNote(User n, String text) {
        return n.getName().contains(text) || n.getLastName().contains(text) || n.getEmail().contains(text);
    }


    @Override
    public List<User> allNotes() throws LogicException {
        try {
            return dao.allNotes();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

}
