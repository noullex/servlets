package com.company.servlets.logic;

import com.company.servlets.logic.content.Role;
import com.company.servlets.logic.content.User;
import java.io.File;
import java.util.List;

public class Controller {

    public static User CURRENT_USER = null;

    public List<User> users;
    public File file;
    private Parser parser;

    public Controller(String path) {
        parser = new Parser();
        file = new File(path + File.separator + "users.xml");
        users = parser.unmarshall(file);
    }

    public Role getUserRole(String login, String password) {
        if (checkLogin(login)) {
            if (checkPassword(password)) {
                return CURRENT_USER.getRole();
            }
        }
        return Role.NONREGISTERED;
    }

    public void register(String login, String password) {
        if (!checkLogin(login)) {
            CURRENT_USER = new User(login, password, Role.USER);
            users.add(CURRENT_USER);
            parser.marshall(file, users);
        }
    }

    private boolean checkLogin(String login) {
        for (User u : users) {
            if (u.getLogin().equals(login)) {
                CURRENT_USER = u;
                return true;
            }
        }
        return false;
    }

    private boolean checkPassword(String password) {
        if (CURRENT_USER.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
