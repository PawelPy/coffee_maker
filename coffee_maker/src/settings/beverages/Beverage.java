package settings.beverages;

import settings.resourceContainers.Containers;
import settings.resourceContainers.Resource;
import settings.userPanel.DisplayPanel;

import java.util.*;

public class Beverage implements Brewing {

    private final String name;
    private final int recipeOfKawa;
    private final int recipeOfMleko;
    private final int recipeOfWoda;
    private final Map<Resource, Integer> recipesOfBeverage;

    public Beverage(String name, int recipeOfKawa, int recipeOfMleko, int recipeOfWoda) {
        this.name = name;
        this.recipeOfKawa = recipeOfKawa;
        this.recipeOfMleko = recipeOfMleko;
        this.recipeOfWoda = recipeOfWoda;

        this.recipesOfBeverage = new HashMap<>();
        this.getRecipesOfBeverage().put(Resource.KAWA, recipeOfKawa);
        this.getRecipesOfBeverage().put(Resource.MLEKO, recipeOfMleko);
        this.getRecipesOfBeverage().put(Resource.WODA, recipeOfWoda);

    }


    @Override
    public void brewing(Containers containers) throws InterruptedException {

        for (Resource resource : getRecipesOfBeverage().keySet()) {
            int containerStatusChangeSize = getRecipesOfBeverage().get(resource);
            int containerStatus = containers.getCurrentContainersStatus().get(resource);
            if (containerStatus < containerStatusChangeSize) {
                containers.ifToRefill(resource);
            }
            containers.getCurrentContainersStatus().put(resource, (containers.getCurrentContainersStatus().get(resource) - containerStatusChangeSize));
        }
        System.out.print("Trwa przygotowanie " + getName());
        System.out.print(DisplayPanel.processingDotsDisplay() + "\n");
    }



    public Map<Resource, Integer> getRecipesOfBeverage() {
        return recipesOfBeverage;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage beverage)) return false;
        return recipeOfKawa == beverage.recipeOfKawa && recipeOfMleko == beverage.recipeOfMleko && recipeOfWoda == beverage.recipeOfWoda && Objects.equals(getName(), beverage.getName()) && Objects.equals(getRecipesOfBeverage(), beverage.getRecipesOfBeverage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), recipeOfKawa, recipeOfMleko, recipeOfWoda, getRecipesOfBeverage());
    }

}
