package summative_assessment;

import models.StockItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Startup {

    public static ArrayList<StockItem> stockList = new ArrayList(); //needs to be public static for access in other classes

    public static void main(String[] args) {
        Startup startup = new Startup();
        startup.importStockList();
    }

    public void importStockList() {
        try {
            BufferedReader importList = new BufferedReader(
                    new FileReader("C:\\Users\\joshua.lawlor\\OneDrive - Accenture\\Desktop\\SummativeAssessmentOutput.txt"));
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
                    importNumberInStock = Integer.parseInt(s);
                    ;
                    counter = 1;
                    stockList.add(new StockItem(importName, importPrice, importManufacturer, importProductID, importNumberInStock));
                } else {
                }
            }
            importList.close();
            System.out.println("Imported stock list for checking purposes.");
            for (StockItem i : stockList) {
                System.out.println("ID [" + i.productID + "] - Amount [" + i.manufacturer +
                        "] - Name [" + i.name + "] - Price [" + i.price + "] - Stock [" + i.numberInStock + "]");
            }
            System.out.println("Stocklist entry size: " + stockList.size());
        } catch (Exception ex) {
            stockList.add(new StockItem("Diamond", 1000, "Wilber Corp", "1", 10));
            stockList.add(new StockItem("Ruby", 2000, "Wilber Corp", "2", 20));
            stockList.add(new StockItem("Sapphire", 3000, "Kyogre Inc", "3", 30));
            stockList.add(new StockItem("Emerald", 4000, "Grune Enterprise", "4", 40));
        }

        LoginMenu loginMenu = new LoginMenu();
        loginMenu.importUserList();
    }
}
