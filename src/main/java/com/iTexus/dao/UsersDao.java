package com.iTexus.dao;

import com.iTexus.entity.User;

import java.util.List;

public interface UsersDao {

    void save(User n) throws DaoException;

    List<User> allNotes() throws DaoException;

    void update(List<User> notes) throws DaoException;

    User deleteById(int id) throws DaoException;
}
