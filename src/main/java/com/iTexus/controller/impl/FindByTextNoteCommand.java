package com.iTexus.controller.impl;


import com.iTexus.logic.LogicException;
import com.iTexus.logic.LogicProvider;
import com.iTexus.logic.UsersLogic;
import com.iTexus.controller.Command;
import com.iTexus.entity.User;

import java.util.List;

public class FindByTextNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UsersLogic logic = logicProvider.getUserLogic();


    @Override
    public String execute(String request) {

        String response;
        List<User> result;

        try {
            result = logic.find(request);

            if (result.size() == 0) {
                response = "The record was not found!";
            } else {
                response = "The user(s) was successfully found";
                for (User n : result) {
                    System.out.println(n);
                }
            }
        } catch (LogicException e) {
            response = "Something went wrong!";
        }

        return response;
    }


}

