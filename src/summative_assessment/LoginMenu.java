package summative_assessment;

import models.StockItem;
import models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {

    public static ArrayList<User> userList = new ArrayList();
    Scanner scn = new Scanner(System.in);
    public static String inputedUser;
    String inputedPassword;


    public void importUserList() {
        try {
            BufferedReader importList = new BufferedReader(
                    new FileReader("C:\\Users\\joshua.lawlor\\OneDrive - Accenture\\Desktop\\SummativeAssessmentUserOutput.txt"));
            String s;
            int counter = 1;
            String importUsername = "";
            String importPassword = "";
            String importForename = "";
            String importSurname = "";
            String ID = "";
            Boolean admin = false;
            while ((s = importList.readLine()) != null) {
                if (counter == 1) {
                    importUsername = s;
                    counter = 2;
                } else if (counter == 2) {
                    importPassword = s;
                    counter = 3;
                } else if (counter == 3) {
                    importForename = s;
                    counter = 4;
                } else if (counter == 4) {
                    importSurname = s;
                    counter = 5;
                } else if (counter == 5) {
                    ID = s;
                    ;
                    counter = 6;
                } else if (counter == 6) {
                    admin = Boolean.valueOf(s);
                    ;
                    counter = 1;
                    userList.add(new User(importUsername, importPassword, importForename, importSurname, ID, admin));
                } else {
                }
            }
            System.out.println("User import successful.");
            importList.close();

        } catch (Exception ex) {
            userList.add(new User("aaa", "aaa", "aaa", "aaa", "aaa", true));
            userList.add(new User("bbb", "bbb", "bbb", "bbb", "bbb", false));
        }
        login();
    }


    public void login() {
        System.out.println("Welcome!");
        System.out.println("Please enter a username.");
        inputedUser = (scn.nextLine());
        System.out.println("Please enter a password.");
        inputedPassword = (scn.nextLine());
        checkDetails();
        detailsGateway();
    }

    public boolean checkDetails() {
        for (User u : userList) {
            if (u.username.equalsIgnoreCase(inputedUser) &&
                    u.password.equalsIgnoreCase(inputedPassword)) {
                return true;
            }
        }
        return false;
    }

    public void detailsGateway() {
        if (checkDetails()) {
            System.out.println("Correct details entered.");
            System.out.println("Going to main menu.");
            MainMenu mainMenu = new MainMenu();
            mainMenu.mainMenu();
        } else {
            System.out.println("Incorrect username and / or password, please try again.");
            login();
        }
    }
}
