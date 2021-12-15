package models;

public class User {
    public String username;
    public String password;
    public String forename;
    public String surname;
    public String ID;
    public Boolean admin;

    public User(String username, String password, String forename, String surname, String ID, Boolean admin) {
        this.username = username;
        this.password = password;
        this.forename = forename;
        this.surname = surname;
        this.ID = ID;
        this.admin = admin;
    }
}
