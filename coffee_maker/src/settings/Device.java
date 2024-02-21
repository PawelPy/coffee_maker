package settings;

import settings.beverages.Beverage;
import java.util.Map;


@FunctionalInterface
public interface Device {

    void deviceRun(Map<Integer, Beverage> beverageMenu) throws Exception;

}
