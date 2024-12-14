package financeflow.models.enums;

public enum LoanStatus {
    ACTIVE("Active"),
    PAID_OFF("Paid Off"),
    DEFAULTED("Defaulted");

    private final String displayName;

    LoanStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static LoanStatus fromDatabaseValue(String value) {
        for (LoanStatus status : LoanStatus.values()) {
            if (status.displayName.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown LoanStatus: " + value);
    }
}
