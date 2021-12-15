package summative_assessment;

import models.StockItem;

import java.io.*;
import java.util.Scanner;

public class MainMenu {

    Scanner scn = new Scanner(System.in);
    int editUser = 0; //for removing user

    public void mainMenu() {

        System.out.println("Welcome to Wilbur's Emporium!");
        System.out.println("What would you like to do today?");
        System.out.println("1 - View the stock list.");
        System.out.println("2 - Add a new item.");
        System.out.println("3 - Remove an item.");
        System.out.println("4 - Edit an item.");
        System.out.println("5 - Export List.");
        System.out.println("6 - Import List");
        System.out.println("7 - Leave the Emporium.");
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
                exportStockList();
                break;
            case 6:
                System.out.println("not available atm");
                break;
            case 7:
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
        Startup.stockList.add(new StockItem(a, b, c, d, e));
        exportStockList();
        mainMenu();
    }

    private void removeItem() {
        //String itemDeletion;
        // System.out.println("enter item ID for deletion.");
        // itemDeletion = (scn.nextLine());
        int index = -1;
        String itemDeletion = (scn.nextLine());
        for (StockItem i : Startup.stockList) {
            if (i.productID.equals(itemDeletion)) {
                index = Startup.stockList.indexOf(i);
                System.out.println("Valid ID entered.");
            } else {
            }
        }
        if (index != -1 && editUser == 0) {
            Startup.stockList.remove(index);
            System.out.println("Item ID [" + itemDeletion + "] has been deleted. ");
        } else if (index != -1 && editUser == 1) {
            Startup.stockList.remove(index);
            editUser = 0;
            addItem();
        } else {
            System.out.println("Invalid ID entered");
        }
        exportStockList();
        mainMenu();
    }

    private void viewStockList() {
        for (StockItem i : Startup.stockList) {
            System.out.println("ID [" + i.productID + "] - Amount [" + i.manufacturer +
                    "] - Name [" + i.name + "] - Price [" + i.price + "] - Stock [" + i.numberInStock + "]");
        }
        mainMenu();
    }

    public void exportStockList() {
        try {
            BufferedWriter exportList = new BufferedWriter(
                    new FileWriter("C:\\Users\\joshua.lawlor\\OneDrive - Accenture\\Desktop\\SummativeAssessmentOutput.txt"));
            for (StockItem i : Startup.stockList) {
                String a = i.name + "\n";
                String b = String.valueOf(i.price) + "\n";
                String c = i.manufacturer + "\n";
                String d = i.productID + "\n";
                String e = String.valueOf(i.numberInStock) + "\n";
                exportList.write(a + b + c + d + e);
            }
            exportList.close();

        } catch (Exception ex) {
            return;
        }
        mainMenu();
    }


}
