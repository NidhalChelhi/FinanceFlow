package financeflow.models.enums;

public enum LoanType {
    PERSONAL("Personal"),
    MORTGAGE("Mortgage"),
    BUSINESS("Business");

    private final String displayName;

    LoanType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static LoanType fromDatabaseValue(String value) {
        for (LoanType type : LoanType.values()) {
            if (type.displayName.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown LoanType: " + value);
    }
}
