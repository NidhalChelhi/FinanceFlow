package financeflow.models.enums;

public enum AccountStatus {
    ACTIVE("Active"),
    CLOSED("Closed"),
    SUSPENDED("Suspended");

    private final String databaseValue;

    AccountStatus(String databaseValue) {
        this.databaseValue = databaseValue;
    }

    // Method to get the database-friendly string value
    public String getDatabaseValue() {
        return databaseValue;
    }

    // Method to convert a database string value back to an enum
    public static AccountStatus fromDatabaseValue(String databaseValue) {
        for (AccountStatus status : values()) {
            if (status.databaseValue.equalsIgnoreCase(databaseValue)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown AccountStatus: " + databaseValue);
    }
}
