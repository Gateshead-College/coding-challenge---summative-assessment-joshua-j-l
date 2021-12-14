package summative_assessment;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MainMenu {

    ArrayList<StockItem> stockList = new ArrayList();
    ArrayList<StockItem> mainImportList = new ArrayList();
    Scanner scn = new Scanner(System.in);
    int editUser = 0;

    public static void main(String[] args) {

        MainMenu startProgram = new MainMenu();
        startProgram.populateList();
        startProgram.mainMenu();
    }

    private void populateList() {


        stockList.add(new StockItem("Diamond", 1000, "Wilber Corp", "1", 10));
        stockList.add(new StockItem("Ruby", 2000, "Wilber Corp", "2", 20));
        stockList.add(new StockItem("Sapphire", 3000, "Kyogre Inc", "3", 30));
        stockList.add(new StockItem("Emerald", 4000, "Grune Enterprise", "4", 40));
    }

    private void mainMenu() {
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
                importStockList();
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

    public void exportStockList() {
        try {
            BufferedWriter exportList = new BufferedWriter(
                    new FileWriter("C:\\Users\\joshua.lawlor\\OneDrive - Accenture\\Desktop\\output2.txt"));
            for (StockItem i : stockList) {
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

    public void importStockList() {
        try {
            BufferedReader importList = new BufferedReader(
                    new FileReader("C:\\Users\\joshua.lawlor\\OneDrive - Accenture\\Desktop\\output2.txt"));
            String s;
            int counter = 1;
            String importName = "Blank";
            int importPrice = -1;
            String importManufacturer = "Blank";
            String importProductID = "Blank";
            int importNumberInStock;
            while ((s = importList.readLine()) != null) {
                if (counter == 1) {
                    importName = s;
                    counter = 2;
                } else if (counter == 2) {
                    importPrice = Integer.parseInt(s);
                    counter = 3;
                } else if (counter == 3) {
                    importManufacturer = s;
                    counter = 4;
                } else if (counter == 4) {
                    importProductID = s;
                    counter = 5;
                } else if (counter == 5) {
                    importNumberInStock = Integer.parseInt(s);;
                    counter = 1;
                    mainImportList.add(new StockItem(importName, importPrice, importManufacturer, importProductID, importNumberInStock));
                } else {
                }
            }
            importList.close();

            for (StockItem i : mainImportList) {
                System.out.println("ID [" + i.productID + "] - Amount [" + i.manufacturer +
                        "] - Name [" + i.name + "] - Price [" + i.price + "] - Stock [" + i.numberInStock + "]");

            }
            System.out.println(mainImportList.size());


        } catch (Exception ex) {
            return;
        }
        mainMenu();
    }


}













