package financeflow.models.accounts;

public class CreditLimit {
    private int id;
    private int clientId;
    private double creditLimit;
    private double usedCredit;
    private double availableCredit;

    // No-arg constructor
    public CreditLimit() {}

    // Full constructor
    public CreditLimit(int clientId, double creditLimit, double usedCredit, double availableCredit) {
        this.clientId = clientId;
        this.creditLimit = creditLimit;
        this.usedCredit = usedCredit;
        this.availableCredit = availableCredit;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getUsedCredit() {
        return usedCredit;
    }

    public void setUsedCredit(double usedCredit) {
        this.usedCredit = usedCredit;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(double availableCredit) {
        this.availableCredit = availableCredit;
    }

    @Override
    public String toString() {
        return "CreditLimit{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", creditLimit=" + creditLimit +
                ", usedCredit=" + usedCredit +
                ", availableCredit=" + availableCredit +
                '}';
    }
}
