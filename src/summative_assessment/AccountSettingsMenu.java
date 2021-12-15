package summative_assessment;

import models.StockItem;
import models.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
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
        exportUserList();
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
        accountsSettingsView.accountSettingsMenu();
    }








}