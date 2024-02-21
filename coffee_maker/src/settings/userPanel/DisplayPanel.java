package settings.userPanel;

import settings.beverages.Beverage;
import settings.resourceContainers.Containers;
import java.util.Map;

public class DisplayPanel {

    public static void beverageMenuDisplay(Map<Integer, Beverage> beverageMenu) {
        beverageMenu.forEach((key, value) -> System.out.println("[" + key + "] " + value.getName()));
        System.out.println("[0] *serwis wyświetl stan zasobników");
    }

    public static void containersStatusDisplay(Containers containers) {
        System.out.println("\nStan zasobników:");
        containers.getCurrentContainersStatus().forEach((key, value) -> System.out.println(key.toString() + ": " + value));
        System.out.println();
    }

    public static String processingDotsDisplay() throws InterruptedException {
        String string = " ";
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            Thread.sleep(200);
        }
        System.out.println();
        return string;
    }



}
