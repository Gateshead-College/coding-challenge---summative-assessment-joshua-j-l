package summative_assessment;

import models.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginMenu {

    public static ArrayList<User> userList = new ArrayList();
    Scanner scn = new Scanner(System.in);
    public static String inputedUser;
    String inputedPassword;

    public void login() {
        userList.add(new User("aaa", "aaa", "aaa", "aaa", "aaa", true));
        userList.add(new User("bbb", "bbb", "bbb", "bbb", "bbb",  false));
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
