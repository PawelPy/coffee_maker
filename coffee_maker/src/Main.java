import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Resource kawa = new Resource("kawa");
        Resource mleko = new Resource("mleko");
        Resource woda = new Resource("woda");


        Map<Resource, Integer> fullResourceStatus = new HashMap<>();
        fullResourceStatus.put(kawa, 10);
        fullResourceStatus.put(mleko, 5);
        fullResourceStatus.put(woda, 10);


        Beverage espresso = new Beverage("Espresso", 2, 0 ,1);
        Beverage cappuccino = new Beverage("Cappuccino", 1,2, 0);
        Beverage americano = new Beverage("Americano", 2, 0, 2);
        Beverage hotMilk = new Beverage("Gorące mleko", 0, 3, 0);
        Beverage hotMilkLarge = new Beverage("Gorące mleko large", 0, 5, 0);
        Beverage espressoDoppio = new Beverage("Espresso Doppio", 4, 0, 2);

        Map<Integer, Beverage> beverageMenu = new HashMap<>();
        beverageMenu.put(1, espresso);
        beverageMenu.put(2, cappuccino);
        beverageMenu.put(3, americano);
        beverageMenu.put(4, hotMilk);
        beverageMenu.put(5, hotMilkLarge);
        beverageMenu.put(6, espressoDoppio);
        
        Device.readyForAction(kawa, mleko, woda, fullResourceStatus, beverageMenu);
    }

}
