package Constants;

public enum Pojo2DBEnum {
    STRING("java.lang.String", "varchar"),
    INTEGER("java.lang.Integer", "int"),
    DOUBLE("java.lang.Double", "double"),
    DATE("java.util.Date", "date");

    private String pojoType;
    private String dbType;

    Pojo2DBEnum(String pojoType, String dbType) {
        this.pojoType = pojoType;
        this.dbType = dbType;
    }

    public static String getDBType(String pojoType) {
        for (Pojo2DBEnum entry : Pojo2DBEnum.values()) {
            if (entry.getPojoType().equals(pojoType)) {
                return entry.getDbType();
            }
        }

        return "varchar";
    }

    public String getPojoType() {
        return pojoType;
    }

    public String getDbType() {
        return dbType;
    }
}
