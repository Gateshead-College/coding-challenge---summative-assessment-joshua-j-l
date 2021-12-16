package summative_assessment;

import java.util.Scanner;

public class AdminAccountView {

    Scanner scn = new Scanner(System.in);
   //AdminAccountController aac = new AdminAccountController(); -- !!! cannot have this here! need to put in adminAccountMenu, otherwise, get error
    AccountsSettingsView asv = new AccountsSettingsView();

    public void adminAccountMenu() {
        AdminAccountController aac = new AdminAccountController();
        System.out.println("Welcome admin.");
        System.out.println("What would you like to do today");
        System.out.println("1 - View all user details");
        System.out.println("2 - Edit user details");
        System.out.println("3 - Return to account menu");
        Integer adminMenuChoice = Integer.valueOf(scn.nextLine());
        switch (adminMenuChoice) {
            case 1:
                aac.viewUsers();
                break;
            case 2:
                aac.editUserChecker();
                break;
            case 3:
                asv.accountSettingsMenu();
            default:
                return;
        }
    }
}