import java.util.Map;
import java.util.Objects;

public class Beverage {

    private final String nameOfBeverage;
    private final int recipeOfKawa;
    private final int recipeOfMleko;
    private final int recipeOfWoda;

    public Beverage(String nameOfBeverage, int recipeOfKawa, int recipeOfMleko, int recipeOfWoda) {
        this.nameOfBeverage = nameOfBeverage;
        this.recipeOfKawa = recipeOfKawa;
        this.recipeOfMleko = recipeOfMleko;
        this.recipeOfWoda = recipeOfWoda;
    }




    public void preparing(Resource kawa, Resource mleko, Resource woda, Map<Resource, Integer> fullResourceStatus, Beverage beverage) throws InterruptedException {

        if (kawa.getCurrentStatusOfResource() < beverage.getRecipeOfKawa()) {
            kawa.toRefill(kawa, fullResourceStatus);
        }
        if (mleko.getCurrentStatusOfResource() < beverage.getRecipeOfMleko()) {
            mleko.toRefill(mleko, fullResourceStatus);
        }
        if (woda.getCurrentStatusOfResource() < beverage.getRecipeOfWoda()) {
            woda.toRefill(woda, fullResourceStatus);
        }

        System.out.print("Trwa przygotowanie " + beverage.getNameOfBeverage());
        System.out.print(UserPanel.processingDot() + "\n");
    }

    public String getNameOfBeverage() {
        return nameOfBeverage;
    }

    public int getRecipeOfKawa() {
        return recipeOfKawa;
    }

    public int getRecipeOfMleko() {
        return recipeOfMleko;
    }

    public int getRecipeOfWoda() {
        return recipeOfWoda;
    }


    @Override
    public String toString() {
        return nameOfBeverage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage beverage)) return false;
        return getRecipeOfKawa() == beverage.getRecipeOfKawa() && getRecipeOfMleko() == beverage.getRecipeOfMleko() && getRecipeOfWoda() == beverage.getRecipeOfWoda() && Objects.equals(getNameOfBeverage(), beverage.getNameOfBeverage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameOfBeverage(), getRecipeOfKawa(), getRecipeOfMleko(), getRecipeOfWoda());
    }

}
