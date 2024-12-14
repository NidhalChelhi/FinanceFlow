package financeflow.models.enums;

public enum AccountType {
    SAVINGS("Savings"),
    CHECKING("Checking"),
    BUSINESS("Business");

    private final String databaseValue;

    AccountType(String databaseValue) {
        this.databaseValue = databaseValue;
    }

    public String getDatabaseValue() {
        return databaseValue;
    }

    public static AccountType fromDatabaseValue(String databaseValue) {
        for (AccountType type : values()) {
            if (type.databaseValue.equalsIgnoreCase(databaseValue)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown AccountType: " + databaseValue);
    }
}
