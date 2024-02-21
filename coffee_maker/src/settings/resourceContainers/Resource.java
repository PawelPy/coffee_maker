package settings.resourceContainers;

public enum Resource {

    KAWA ("kawa"),
    MLEKO ("mleko"),
    WODA ("woda");

    private final String name;

    Resource(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
