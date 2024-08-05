package com.iTexus.dao.impl;

import com.iTexus.util.GenerateId;
import com.iTexus.dao.DaoException;
import com.iTexus.dao.UsersDao;
import com.iTexus.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the Dao layer: working with the data source file users.txt
 */

public class UserRecordDao implements UsersDao {

    @Override
    public List<User> allNotes() throws DaoException {

        BufferedReader reader = null;
        List<User> allNotes = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/users.txt"));
            String line;
            String split = "\t";
            int id;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(split);
                id = Integer.parseInt(parts[0]);

                parts[4] = parts[4].replaceAll("[\\[\\]]", "");
                parts[5] = parts[5].replaceAll("[\\[\\]]", "");

                List<String> listPhoneNumbers = Arrays.asList(parts[4].split(", "));
                List<String> listRoles = Arrays.asList(parts[5].split(", "));

                allNotes.add(new User(id, parts[1], parts[2], parts[3], listPhoneNumbers, listRoles));
            }
        } catch (FileNotFoundException e) {
            throw new DaoException(e);
        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                throw new DaoException(e);
            }
        }
        return allNotes;
    }

    @Override
    public void save(User n) throws DaoException {

        List<User> notes = allNotes();
        BufferedWriter bufWriter = null;

        try {
            bufWriter = new BufferedWriter(new FileWriter("src/main/resources/users.txt", true));

            if (notes.size() > 0) {
                GenerateId.checkLastId(notes);
                n.setId(GenerateId.nextId());
            }

            bufWriter.write(n.getId() + "\t" + n.getName() + "\t" + n.getLastName() + "\t" + n.getEmail()
                    + "\t" + n.getPhoneNumbers() + "\t" + n.getRoles() + "\r\n");

        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            try {
                if (bufWriter != null) {
                    bufWriter.close();
                }
            } catch (IOException e) {
                throw new DaoException(e);
            }
        }

    }

    public void update(List<User> updatedNotes) throws DaoException {

        BufferedWriter bufWriter = null;
        try {
            bufWriter = new BufferedWriter(new FileWriter("src/main/resources/users.txt"));

            for (User n : updatedNotes) {
                bufWriter.write(n.getId() + "\t" + n.getName() + "\t" + n.getLastName() + "\t" + n.getEmail()
                        + "\t" + n.getPhoneNumbers() + "\t" + n.getRoles() + "\r\n");
            }
        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            try {
                if (bufWriter != null) {
                    bufWriter.close();
                }
            } catch (IOException e) {
                throw new DaoException(e);
            }
        }

    }

    public User deleteById(int id) throws DaoException {
        List<User> allNotes = allNotes();
        User deletedUser = null;

        for (int i = 0; i < allNotes.size(); i++) {
            if (id == allNotes.get(i).getId()) {
                deletedUser = allNotes.get(i);
                allNotes.remove(i);
            }
        }

        update(allNotes);
        return deletedUser;
    }
}