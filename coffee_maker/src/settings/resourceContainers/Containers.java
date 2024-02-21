package settings.resourceContainers;

import java.util.*;

public class Containers implements ContainerRefiller {

    private final Map<Resource, Integer> maxContainersStatus = new LinkedHashMap<>();
    private Map<Resource, Integer> currentContainersStatus = new LinkedHashMap<>();

    public Containers() {

        this.getCurrentContainersStatus().put(Resource.KAWA, 10);
        this.getCurrentContainersStatus().put(Resource.MLEKO, 5);
        this.getCurrentContainersStatus().put(Resource.WODA, 10);

        this.getMaxContainersStatus().put(Resource.KAWA, 10);
        this.getMaxContainersStatus().put(Resource.MLEKO, 5);
        this.getMaxContainersStatus().put(Resource.WODA, 10);
    }

    @Override
    public void ifToRefill(Resource resource) {

        int toRefill = getMaxContainersStatus().get(resource) - getCurrentContainersStatus().get(resource);
        System.out.println("Zasobnik " + resource + " wymaga uzupełnienia, dodaj: " + toRefill);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[0] *serwis uzupełnij zasobnik*");
            String serviceString = scanner.nextLine();

            try {
                int service = Integer.parseInt(serviceString);
                if (service == 0) {
                    getCurrentContainersStatus().put(resource, (getCurrentContainersStatus().get(resource) + toRefill));
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("nie ma takiego numeru :)\n");
            }
        }
    }

    public Map<Resource, Integer> getMaxContainersStatus() {
        return maxContainersStatus;
    }
    public Map<Resource, Integer> getCurrentContainersStatus() {
        return currentContainersStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Containers that)) return false;
        return Objects.equals(getMaxContainersStatus(), that.getMaxContainersStatus()) && Objects.equals(getCurrentContainersStatus(), that.getCurrentContainersStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxContainersStatus(), getCurrentContainersStatus());
    }


}
