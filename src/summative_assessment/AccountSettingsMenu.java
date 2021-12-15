package summative_assessment;

import models.StockItem;
import models.User;

import java.util.Scanner;

public class AccountSettingsMenu {
    Scanner scn = new Scanner(System.in);
    AccountsSettingsView accountsSettingsView = new AccountsSettingsView();

    // function for password editing
    public void editPasswords() {
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        Boolean f = false;
        for (User i : LoginMenu.userList) {
            if (i.username.equalsIgnoreCase(LoginMenu.inputedUser)) {
                a = i.username;
                b = i.password;
                c = i.forename;
                d = i.surname;
                e = i.ID;
                f = i.admin;
                LoginMenu.userList.remove(i);
            }
        }
        System.out.println("Please enter new password");
        b = (scn.nextLine());
        LoginMenu.userList.add(new User(a, b, c, d, e, f));
        accountsSettingsView.accountSettingsMenu();
    }

    public void displayUserInfo() {
        for (User i : LoginMenu.userList) {
            if (i.username.equalsIgnoreCase(LoginMenu.inputedUser)) {
                System.out.println("ID [" + i.username + "] - Amount [" + i.password +
                        "] - Name [" + i.forename + "] - Price [" + i.surname + "] - Stock [" + i.ID + "] Admin [" + i.admin + "]");
            }
        }
        accountsSettingsView.accountSettingsMenu();
    }

    public void returnMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
    }
}