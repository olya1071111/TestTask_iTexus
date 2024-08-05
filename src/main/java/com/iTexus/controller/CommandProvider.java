package com.iTexus.controller;

import com.iTexus.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD, new AddNoteCommand());
        repository.put(CommandName.UPDATE, new UpdateNoteCommand());
        repository.put(CommandName.DELETE, new DeleteNoteCommand());
        repository.put(CommandName.FIND_BY_TEXT, new FindByTextNoteCommand());
        repository.put(CommandName.ALL_NOTES, new AllNotesCommand());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
        }
        return command;
    }

}
