import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Device {

    public static void readyForAction(Resource kawa, Resource mleko, Resource woda, Map<Resource, Integer> fullResourceStatus, Map<Integer, Beverage> beverageMenu) throws Exception {

        fullResourceStatus.forEach((key, value) -> key.setStatusOfResource(fullResourceStatus.get(key)));

        while (true) {
            Beverage beverage;
            Scanner scanner = new Scanner(System.in);
            UserPanel.beverageMenuShow(beverageMenu);

            try {
                int beverageChoice = scanner.nextInt();

                if (beverageChoice > 0 && beverageChoice <= beverageMenu.size()) {
                    beverage = beverageMenu.get(beverageChoice);
                    beverage.preparing(kawa, mleko, woda, fullResourceStatus, beverage);

                    Resource.updateStatusOfResource(kawa, mleko, woda, beverage);

                } else if (beverageChoice == 0) {
                    UserPanel.allResourceCurrentStatusShow(fullResourceStatus);
                } else if (beverageChoice == 'q') {
                    throw new Exception();
                } else {
                    System.out.println("nie ma takiego numeru :)\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Off.");
                break;
            }

        }
    }

}
