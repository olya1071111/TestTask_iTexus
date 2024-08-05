package com.iTexus.logic;

import com.iTexus.logic.impl.UserRecordLogicImpl;

public class LogicProvider {
    private static final LogicProvider INSTANCE = new LogicProvider();

    private LogicProvider() {
    }

    private final UsersLogic userLogic = new UserRecordLogicImpl();

    public UsersLogic getUserLogic() {
        return userLogic;
    }

    public static LogicProvider getInstance() {
        return INSTANCE;
    }

}
