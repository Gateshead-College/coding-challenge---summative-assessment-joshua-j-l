package summative_assessment;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    ArrayList<StockItem> stockList = new ArrayList();
    Scanner scn = new Scanner(System.in);
    int editUser = 0;

    public static void main(String[] args) {

        MainMenu startProgram = new MainMenu();
        startProgram.populateList();
        startProgram.mainMenu();
    }

    private void populateList() {
        stockList.add(new StockItem("Diamond", 1000, "Wilber Corp", "1", 1));
        stockList.add(new StockItem("Ruby", 2000, "Wilber Corp", "2", 2));
        stockList.add(new StockItem("Sapphire", 3000, "Kyogre Inc", "3", 4));
        stockList.add(new StockItem("Emerald", 4000, "Grune Enterprise", "4", 8));
    }

    private void mainMenu() {
        System.out.println("Welcome to Wilbur's Emporium!");
        System.out.println("What would you like to do today?");
        System.out.println("1 - View the stock list.");
        System.out.println("2 - Add a new item.");
        System.out.println("3 - Remove an item.");
        System.out.println("4 - Edit an item.");
        System.out.println("5 - Leave the Emporium.");
        Integer mainMenuChoice = Integer.valueOf(scn.nextLine());
        switch (mainMenuChoice) {
            case 1:
                viewStockList();
                break;
            case 2:
                addItem();
                break;
            case 3:
                System.out.println("Which item would you like to delete?");
                System.out.println("Enter item ID");
                removeItem();
                break;
            case 4:
                editUser = 1;
                System.out.println("which item would you like to edit?");
                System.out.println("Enter item ID");
                removeItem();

                break;
            case 5:
                System.out.println("Have a nice day!");
                break;
            default:
                return;
        }
    }

    private void addItem() {
        System.out.println("please input a name");
        String a = (scn.nextLine());
        System.out.println("please input a price");
        Integer b = Integer.valueOf(scn.nextLine());
        System.out.println("please input a manufacturer");
        String c = (scn.nextLine());
        System.out.println("please input a productID");
        String d = (scn.nextLine());
        System.out.println("please input the number in stock");
        Integer e = Integer.valueOf(scn.nextLine());
        stockList.add(new StockItem(a, b, c, d, e));
        mainMenu();
    }

    private void removeItem() {
        //String itemDeletion;
        // System.out.println("enter item ID for deletion.");
        // itemDeletion = (scn.nextLine());
        int index = -1;
        String itemDeletion = (scn.nextLine());
        for (StockItem i : stockList) {
            if (i.productID.equals(itemDeletion)) {
                index = stockList.indexOf(i);
                System.out.println("Valid ID entered.");
            } else {
            }
        }
        if (index != -1 && editUser == 0) {
            stockList.remove(index);
            System.out.println("Item ID [" + itemDeletion + "] has been deleted. ");
        } else if (index != -1 && editUser == 1) {
            stockList.remove(index);
            editUser = 0;
            addItem();
        } else {
            System.out.println("Invalid ID entered");
        }
        mainMenu();
    }

    private void viewStockList() {
        for (StockItem i : stockList) {
            System.out.println("ID [" + i.productID + "] - Amount [" + i.manufacturer +
                    "] - Name [" + i.name + "] - Price [" + i.price + "] - Stock [" + i.numberInStock + "]");
        }
        mainMenu();
    }

}













