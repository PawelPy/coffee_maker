package settings.beverages;

import settings.resourceContainers.Containers;

public interface Brewing {

    void brewing(Containers containers) throws InterruptedException;
}
