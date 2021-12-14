package summative_assessment;

import java.util.ArrayList;

public class MainMenu {

    ArrayList<String> stockList = new ArrayList();
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        mainMenu.populateList();

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

}
