package summative_assessment;

import models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class AccountSettingsMenu {
    Scanner scn = new Scanner(System.in);
    AccountsSettingsView accountsSettingsView = new AccountsSettingsView();
    AdminAccountView aav = new AdminAccountView();

    // function for password editing
    public void editPasswords() {
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        Boolean f = false;
        int removeIndex = -1; // has to be int, not Integer, for the .remove method to work!!!

        for (User i : LoginMenu.userList) {
            if (i.username.equalsIgnoreCase(LoginMenu.inputedUser)) {
                a = i.username;
                b = i.password;
                c = i.forename;
                d = i.surname;
                e = i.ID;
                f = i.admin;
                removeIndex = LoginMenu.userList.indexOf(i);
            } else {
            }
        }
        LoginMenu.userList.remove(removeIndex);
        System.out.println("Please enter new password");
        b = (scn.nextLine());
        LoginMenu.userList.add(new User(a, b, c, d, e, f));
        exportUserList();
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

    public void checkAdmin() {
        for (User i : LoginMenu.userList) {
            if (String.valueOf(i.admin).equalsIgnoreCase("true") && i.username.equalsIgnoreCase(LoginMenu.inputedUser)) {
                System.out.println("Access to admin menu granted!");
                aav.adminAccountMenu();
            } else {
                System.out.println("User is not an admin!");
                accountsSettingsView.accountSettingsMenu();
            }
        }
    }

    public void returnMainMenu() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
    }

    public void exportUserList() {
        try {
            BufferedWriter exportList = new BufferedWriter(
                    new FileWriter("C:\\Users\\joshua.lawlor\\OneDrive - Accenture\\Desktop\\SummativeAssessmentUserOutput.txt"));
            for (User i : LoginMenu.userList) {
                String a = i.username + "\n";
                String b = i.password + "\n";
                String c = i.forename + "\n";
                String d = i.surname + "\n";
                String e = i.ID + "\n";
                String f = i.admin + "\n";
                exportList.write(a + b + c + d + e + f);
            }
            exportList.close();

        } catch (Exception ex) {
            return;
        }
    }
}

