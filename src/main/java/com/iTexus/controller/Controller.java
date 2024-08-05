package com.iTexus.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private BufferedReader numIn;
    String delimiter = "--------------------------------------------------------------------------------------------";

    private final CommandProvider provider = new CommandProvider();

    private void startMenu() {
        System.out.println("\nMAIN MENU:");
        System.out.println("If you need to add a user, press - 1");
        System.out.println("If you need to see all users, press - 2");
        System.out.println("if you need to delete the user press - 3");
        System.out.println("If you need to change user settings, press - 4");
        System.out.println("If you need to search user, press - 5");
        System.out.println("If you want to exit press 'E' .");
        System.out.print("Make a choice ---> ");
    }

    public void doAction() throws IOException {

        String commandName = null;
        String request = null;

        boolean endWorking = false;
        numIn = new BufferedReader(new InputStreamReader(System.in));

        while (endWorking == false) {
            startMenu();
            String nStr = numIn.readLine();
            if (nStr.equals("1")) {
                commandName = String.valueOf(CommandName.ADD);
                checkCommand(commandName, request);
                System.out.println(delimiter);
                continue;
            }
            if (nStr.equals("2")) {
                commandName = String.valueOf(CommandName.ALL_NOTES);
                System.out.println();
                checkCommand(commandName, request);
                System.out.println(delimiter);
                continue;
            }
            if (nStr.equals("3")) {
                System.out.print("\nEnter the Id of the user you want to delete --> ");
                request = numIn.readLine();
                commandName = String.valueOf(CommandName.DELETE);
                System.out.println(checkCommand(commandName, request));
                System.out.println(delimiter);
                continue;
            }
            if (nStr.equals("4")) {
                System.out.print("\nEnter the Id of the user you want to update --> ");
                request = numIn.readLine();
                commandName = String.valueOf(CommandName.UPDATE);
                System.out.println(checkCommand(commandName, request));
                System.out.println(delimiter);
                continue;
            }
            if (nStr.equals("5")) {
                System.out.print("\nEnter your name or last name to search for data --> ");
                request = numIn.readLine();
                commandName = String.valueOf(CommandName.FIND_BY_TEXT);
                System.out.println(checkCommand(commandName, request));
                System.out.println(delimiter);
                continue;
            }
            if (nStr.equals("E")) {
                endWorking = true;
            } else {
                System.out.println("Enter the correct number: 1,2,3,4,5 or E");
                System.out.println();
                continue;
            }
        }
    }

    public String checkCommand(String commandName, String request) {

        Command executionCommand;
        String response;

        try {
            executionCommand = provider.getCommand(commandName);

            response = executionCommand.execute(request);
        } catch (IndexOutOfBoundsException e) {
            response = "The request was entered incorrectly!";
        }
        return response;
    }
}
