package com.iTexus.controller.impl;

import com.iTexus.controller.MenuForAddOrApdateUser;
import com.iTexus.logic.LogicException;
import com.iTexus.logic.LogicProvider;
import com.iTexus.logic.UsersLogic;
import com.iTexus.controller.Command;
import com.iTexus.entity.User;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UsersLogic logic = logicProvider.getUserLogic();

    @Override
    public String execute(String request) {

        String response;
        User user = MenuForAddOrApdateUser.DataForAddOrUpdateUser();

        try {
            logic.add(user.getName(),user.getLastName(),user.getEmail(),user.getPhoneNumbers(),user.getRoles());
            response = "The record was saved successfully";
        } catch (LogicException e) {
            response = "The record has not been saved! Something went wrong.";
        }
        return response;
    }

}
