import settings.Device;
import settings.beverages.Beverage;
import settings.userPanel.DisplayPanel;
import settings.resourceContainers.Containers;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Beverage espresso = new Beverage("Espresso", 2, 0, 1);
        Beverage cappuccino = new Beverage("Cappuccino", 1, 2, 0);
        Beverage americano = new Beverage("Americano", 2, 0, 2);
        Beverage hotMilk = new Beverage("Gorące mleko", 0, 3, 0);
        Beverage hotMilkLarge = new Beverage("Gorące mleko large", 0, 5, 0);
        Beverage espressoDoppio = new Beverage("Espresso Doppio", 4, 0, 2);
        Beverage espressoRistretto = new Beverage("Espresso Ristretto", 2, 0, 1);
        Beverage espressoRistrettoDouble = new Beverage("Espresso Ristretto Double", 4, 0, 2);

        Map<Integer, Beverage> beverageMenu = new HashMap<>();
        beverageMenu.put(1, espresso);
        beverageMenu.put(2, cappuccino);
        beverageMenu.put(3, americano);
        beverageMenu.put(4, hotMilk);
        beverageMenu.put(5, hotMilkLarge);
        beverageMenu.put(6, espressoDoppio);
        beverageMenu.put(7, espressoRistretto);
        beverageMenu.put(8, espressoRistrettoDouble);


        Device device = beverMenu -> {

            Containers containers = new Containers();
            Beverage beverage;

            while (true) {
                Scanner scanner = new Scanner(System.in);
                DisplayPanel.beverageMenuDisplay(beverMenu);
                String choiceString = scanner.nextLine();
                if (choiceString.equals("q")) {
                    System.out.println("Ekspres off.");
                    break;
                }
                try {
                    int beverageChoice = Integer.parseInt(choiceString);
                    if (beverageChoice == 0) {
                        DisplayPanel.containersStatusDisplay(containers);
                    } else if (beverageChoice > 0 && beverageChoice <= beverMenu.size()) {
                        beverage = beverMenu.get(beverageChoice);
                        beverage.brewing(containers);
                    } else {
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("nie ma takiego numeru :)\n");
                }
            }
        };
        device.deviceRun(beverageMenu);


    }
}

