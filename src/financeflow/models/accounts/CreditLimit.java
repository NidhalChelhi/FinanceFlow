package financeflow.models.accounts;

import javafx.beans.property.*;

public class CreditLimit {
    private final IntegerProperty id;
    private final IntegerProperty clientId;
    private final DoubleProperty creditLimit;
    private final DoubleProperty usedCredit;
    private final DoubleProperty availableCredit;

    public CreditLimit(int id, int clientId, double creditLimit, double usedCredit, double availableCredit) {
        this.id = new SimpleIntegerProperty(id);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.creditLimit = new SimpleDoubleProperty(creditLimit);
        this.usedCredit = new SimpleDoubleProperty(usedCredit);
        this.availableCredit = new SimpleDoubleProperty(availableCredit);
    }

    // JavaFX Property Methods
    public IntegerProperty idProperty() {
        return id;
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public DoubleProperty creditLimitProperty() {
        return creditLimit;
    }

    public DoubleProperty usedCreditProperty() {
        return usedCredit;
    }

    public DoubleProperty availableCreditProperty() {
        return availableCredit;
    }

    // Getters and Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getClientId() {
        return clientId.get();
    }

    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }

    public double getCreditLimit() {
        return creditLimit.get();
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit.set(creditLimit);
    }

    public double getUsedCredit() {
        return usedCredit.get();
    }

    public void setUsedCredit(double usedCredit) {
        this.usedCredit.set(usedCredit);
        this.availableCredit.set(creditLimit.get() - usedCredit);
    }

    public double getAvailableCredit() {
        return availableCredit.get();
    }
}
