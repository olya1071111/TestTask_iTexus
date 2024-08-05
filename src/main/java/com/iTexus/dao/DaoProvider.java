package com.iTexus.dao;


import com.iTexus.dao.impl.UserRecordDao;

public class DaoProvider {
    private static final DaoProvider INSTANCE = new DaoProvider();

    private DaoProvider() {
    }

    private final UsersDao usersDao = new UserRecordDao();

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public static DaoProvider getInstance() {
        return INSTANCE;
    }
}
