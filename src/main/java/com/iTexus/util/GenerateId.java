package com.iTexus.util;


import com.iTexus.entity.User;

import java.util.List;

public class GenerateId {

    private GenerateId() {}

    private static int nextId = 1;

    public static int nextId() {
        return nextId++;
    }

    public static void checkLastId(List<User> notes) {
        if(notes.size() > 0) {
            int size = notes.size();
            int id = notes.get(size - 1).getId();
            nextId = id+1;
        }

    }
}
