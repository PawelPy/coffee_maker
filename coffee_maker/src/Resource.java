import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Resource {

    private final String name;
    private int statusOfResource;

    public Resource(String name) {
        this.name = name;
    }



    public void toRefill(Resource resource, Map<Resource, Integer> fullResourceStatus) {

        int toRefill = fullResourceStatus.get(resource) - resource.getCurrentStatusOfResource();
        System.out.println("Zasobnik " + resource.getName() + " wymaga uzupełnienia, dodaj: " + toRefill);

        while (true) {
            boolean refilled = false;

            Scanner serwis0 = new Scanner(System.in);
            System.out.println("[0] *serwis uzupełnij zasobnik*");
            int serwisZasobnik = serwis0.nextInt();

            if (serwisZasobnik == 0) {
                resource.setStatusOfResource(resource.getCurrentStatusOfResource() + toRefill);
                refilled = true;
            } else {
                System.out.println("nie ma takiego numeru :)\n");
            }
            if (refilled) {
                break;
            }
        }
    }

    public static void updateStatusOfResource(Resource kawa, Resource mleko, Resource woda, Beverage beverage) {
        kawa.setStatusOfResource(kawa.getCurrentStatusOfResource() - beverage.getRecipeOfKawa());
        mleko.setStatusOfResource(mleko.getCurrentStatusOfResource() - beverage.getRecipeOfMleko());
        woda.setStatusOfResource(woda.getCurrentStatusOfResource() - beverage.getRecipeOfWoda());
    }


    public String getName() {
        return name;
    }

    public int getCurrentStatusOfResource() {
        return statusOfResource;
    }

    public void setStatusOfResource(int statusOfResource) {
        this.statusOfResource = statusOfResource;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource resource)) return false;
        return statusOfResource == resource.statusOfResource && Objects.equals(getName(), resource.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), statusOfResource);
    }


}
