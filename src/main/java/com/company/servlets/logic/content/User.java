package com.company.servlets.logic.content;

public class User {

    private String login;
    private String password;
    private Role role;

    public User() {
    }

    public User(String login, String password, Role role) {
        setLogin(login);
        setPassword(password);
        setRole(role);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
