import java.util.Map;

public class UserPanel {


    public static void beverageMenuShow(Map<Integer, Beverage> beverageMenu) {
        beverageMenu.forEach((key, value) -> System.out.println("[" + key + "] " + value.getNameOfBeverage()));
        System.out.println("[0] *serwis wyświetl stan zasobników");
    }

    public static void allResourceCurrentStatusShow(Map<Resource, Integer> fullResourceStatus) {
        System.out.println("\nStan zasobników:");
        fullResourceStatus.forEach((key, value) -> System.out.println(key.getName() + ": " + key.getCurrentStatusOfResource()));
        System.out.println();
    }

    // proces....
    public static String processingDot() throws InterruptedException {
        String string = " ";
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            Thread.sleep(200);
        }
        System.out.println();
        return string;
    }



}
