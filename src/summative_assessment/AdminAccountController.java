package summative_assessment;

import models.User;

import java.util.Scanner;

public class AdminAccountController {
    AdminAccountView aav = new AdminAccountView();
    AccountSettingsMenu asm = new AccountSettingsMenu();
    Scanner scn = new Scanner(System.in);

    String a = "";
    String b = "";
    String c = "";
    String d = "";
    String e = "";
    Boolean f = false;
    int editUserIndex = -1;

    public void viewUsers() {
        for (User i : LoginMenu.userList) {
            System.out.println("Username [" + i.username + "] - Password [" + i.password +
                    "] - Forename [" + i.forename + "] - Surname [" + i.surname + "] - ID [" + i.ID + "] Admin [" + i.admin + "]");

        }
      aav.adminAccountMenu();
    }

    public void editUserChecker() {
        System.out.println("Which user would you like to edit?");
        String editUser = scn.nextLine();
        String validUser = "";
        Boolean userMatch = false;
        for (User i : LoginMenu.userList) {
            if (i.username.equalsIgnoreCase(editUser)) {
                a = i.username;
                b = i.password;
                c = i.forename;
                d = i.surname;
                e = i.ID;
                f = i.admin;
                editUserIndex = LoginMenu.userList.indexOf(i);
                userMatch = true;
            } else {
            }
        }
        if (userMatch = true) {
            System.out.println("User match!");
            userMatch = false;
            editUserMenu();
        } else {
            System.out.println("Invalid user input");
            aav.adminAccountMenu();
        }
    }

    public void editUserMenu() {
        System.out.println("What would you like to edit");
        System.out.println("1 - username");
        System.out.println("2 - password");
        System.out.println("3 - forename");
        System.out.println("4 - surname");
        System.out.println("5 - ID");
        System.out.println("6 - admin");
        Integer editUserMenuChoice = Integer.valueOf(scn.nextLine());
        switch (editUserMenuChoice) {
            case 1:
                System.out.println("enter new information");
                a = scn.nextLine();
                break;
            case 2:
                System.out.println("enter new information");
                b = scn.nextLine();
                break;
            case 3:
                System.out.println("enter new information");
                c = scn.nextLine();
                break;
            case 4:
                System.out.println("enter new information");
                d = scn.nextLine();
                break;
            case 5:
                System.out.println("enter new information");
                e = scn.nextLine();
                break;
            case 6:
                System.out.println("enter new information");
                f = Boolean.valueOf(scn.nextLine());
                break;
            default:
                break;
        }
        System.out.println("Index position to be deleted: " + editUserIndex);
        LoginMenu.userList.remove(editUserIndex);
        LoginMenu.userList.add(new User(a, b, c, d, e, f));
        asm.exportUserList();
        aav.adminAccountMenu();
    }
}
