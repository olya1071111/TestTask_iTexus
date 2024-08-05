package com.iTexus.controller.impl;


import com.iTexus.controller.MenuForAddOrApdateUser;
import com.iTexus.logic.LogicException;
import com.iTexus.logic.LogicProvider;
import com.iTexus.logic.UsersLogic;
import com.iTexus.controller.Command;
import com.iTexus.entity.User;

public class UpdateNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UsersLogic logic = logicProvider.getUserLogic();

    @Override
    public String execute(String request) {

        String response;
        Integer id = Integer.valueOf(request);

        User user = MenuForAddOrApdateUser.DataForAddOrUpdateUser();

        try {
            logic.update(user, id);
            response = "The record was updated successfully!";
        } catch (LogicException e) {
            response = "The record has not been updated! Something went wrong.";
        }

        return response;
    }

}
