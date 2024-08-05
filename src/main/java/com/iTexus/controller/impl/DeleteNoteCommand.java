package com.iTexus.controller.impl;

import com.iTexus.logic.LogicException;
import com.iTexus.logic.LogicProvider;
import com.iTexus.logic.UsersLogic;
import com.iTexus.controller.Command;
import com.iTexus.entity.User;

public class DeleteNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UsersLogic logic = logicProvider.getUserLogic();

    @Override
    public String execute(String request) {
        String response;
        int id;
        User n;

        id = Integer.parseInt(request);
        try {
            n = logic.deleteById(id);
            response = "The record was deleted successfully";

        } catch (LogicException e) {
            response = "The record has not been deleted! invalid Id number entered";
        }

        return response;
    }

}
