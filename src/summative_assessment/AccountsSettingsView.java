package summative_assessment;

import java.util.Scanner;

public class AccountsSettingsView {

    Scanner scn = new Scanner(System.in);


    public void accountSettingsMenu() {
        AccountSettingsMenu accountSettingsMenuController = new AccountSettingsMenu();
        System.out.println("Welcome to the accounts menu");
        System.out.println("What would you like to do today?");
        System.out.println("1 - Edit password");
        System.out.println("2 - Check user details");
        System.out.println("3 - Return to main menu");
        Integer accountsMenuChoice = Integer.valueOf(scn.nextLine());
        switch (accountsMenuChoice) {
            case 1:
                accountSettingsMenuController.editPasswords();
                break;
            case 2:
                accountSettingsMenuController.displayUserInfo();
                break;
            case 3:
                System.out.println("Taking you back to main menu...");
                accountSettingsMenuController.returnMainMenu();
                break;
            default:
                return;
        }
    }
}
