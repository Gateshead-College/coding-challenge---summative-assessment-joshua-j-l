package summative_assessment;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    ArrayList<String> stockList = new ArrayList();
    Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        MainMenu startProgram = new MainMenu();
        startProgram.populateList();
        startProgram.mainMenu();

    }

    private void populateList() {
        stockList.add("Diamond");
        stockList.add("Ruby");
        stockList.add("Amethyst");
        stockList.add("Sapphire");
        stockList.add("Emerald");
        stockList.add("Opal");
        stockList.add("Tanzanite");
    }

    private void mainMenu() {
        System.out.println("welcome to Wilbur's Emporium!");
        System.out.println("What would you like to do today?");
        System.out.println("1 - View the stock list.");
        System.out.println("2 - Leave the Emporium.");
        Integer mainMenuChoice = Integer.valueOf(scn.nextLine());
        switch (mainMenuChoice) {
            case 1:
                viewStockList();
                break;
            case 2:
                System.out.println("Have a nice day!");
                break;
            default:
                return;

        }

    }

    private void viewStockList() {
        for (int i = 0; i < stockList.size(); i++) {
            System.out.println(stockList.get(i));
            System.out.println();
        }
        mainMenu();
    }


}













