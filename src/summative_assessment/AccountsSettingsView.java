package summative_assessment;

import java.util.Scanner;

public class AccountsSettingsView {

    Scanner scn = new Scanner(System.in);

    public void accountSettingsMenu(){
        System.out.println("Welcome to the accounts menu");
        System.out.println("What would you like to do today?");
        System.out.println("1 - Edit password");
        System.out.println("2 - Return to main menu");
        Integer accountsMenuChoice = Integer.valueOf(scn.nextLine());
        switch (accountsMenuChoice) {
            case 1:
                break;
            case 2:
                System.out.println("Taking you back to main menu...");
                break;
            default:
                return;
        }
    }
}
