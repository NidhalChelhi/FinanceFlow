package financeflow.models.accounts;

import financeflow.models.enums.LoanStatus;
import financeflow.models.enums.LoanType;
import javafx.beans.property.*;

public class Loan {
    private final IntegerProperty id;
    private final ObjectProperty<LoanType> loanType;
    private final DoubleProperty amount;
    private final DoubleProperty interestRate;
    private final IntegerProperty durationInMonths;
    private final IntegerProperty clientId;
    private final StringProperty clientName; // Added for display
    private final ObjectProperty<LoanStatus> status;

    public Loan(int id, LoanType loanType, double amount, double interestRate, int durationInMonths, int clientId, String clientName, LoanStatus status) {
        this.id = new SimpleIntegerProperty(id);
        this.loanType = new SimpleObjectProperty<>(loanType);
        this.amount = new SimpleDoubleProperty(amount);
        this.interestRate = new SimpleDoubleProperty(interestRate);
        this.durationInMonths = new SimpleIntegerProperty(durationInMonths);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.clientName = new SimpleStringProperty(clientName);
        this.status = new SimpleObjectProperty<>(status);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public ObjectProperty<LoanType> loanTypeProperty() {
        return loanType;
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public DoubleProperty interestRateProperty() {
        return interestRate;
    }

    public IntegerProperty durationProperty() {
        return durationInMonths;
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public StringProperty clientNameProperty() {
        return clientName;
    }

    public ObjectProperty<LoanStatus> statusProperty() {
        return status;
    }

    // Getters
    public int getId() {
        return id.get();
    }

    public LoanType getLoanType() {
        return loanType.get();
    }

    public double getAmount() {
        return amount.get();
    }

    public double getInterestRate() {
        return interestRate.get();
    }

    public int getDurationInMonths() {
        return durationInMonths.get();
    }

    public int getClientId() {
        return clientId.get();
    }

    public String getClientName() {
        return clientName.get();
    }

    public LoanStatus getStatus() {
        return status.get();
    }

    // Setters
    public void setLoanType(LoanType loanType) {
        this.loanType.set(loanType);
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public void setInterestRate(double interestRate) {
        this.interestRate.set(interestRate);
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths.set(durationInMonths);
    }

    public void setClientName(String clientName) {
        this.clientName.set(clientName);
    }

    public void setStatus(LoanStatus status) {
        this.status.set(status);
    }
}
