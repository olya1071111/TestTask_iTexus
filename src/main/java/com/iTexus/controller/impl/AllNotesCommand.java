package com.iTexus.controller.impl;

import com.iTexus.logic.LogicException;
import com.iTexus.logic.LogicProvider;
import com.iTexus.logic.UsersLogic;
import com.iTexus.controller.Command;
import com.iTexus.entity.User;

import java.util.List;

public class AllNotesCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final UsersLogic logic = logicProvider.getUserLogic();

    @Override
    public String execute(String request) {

        String response;
        List<User> users;

        try {
            users = logic.allNotes();

            if (users.size() == 0) {
                response = "No records found!";
            } else {
                response = "All entries were received successfully";
                System.out.println("List of all users");
                for (User n : users) {
                    System.out.println(n);
                }
            }
        } catch (LogicException e) {
            response = "Something went wrong!";
        }

        return response;
    }
}
