package financial_management.util.Cache;

public enum  CacheType {

    PROPERTIES("Properties", String.class);

    public String type;

    public Class clazz;

    CacheType() {
    }

    CacheType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
}
