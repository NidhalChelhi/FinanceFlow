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
    private final ObjectProperty<LoanStatus> status;

    public Loan(int id, LoanType loanType, double amount, double interestRate, int durationInMonths, int clientId, LoanStatus status) {
        this.id = new SimpleIntegerProperty(id);
        this.loanType = new SimpleObjectProperty<>(loanType);
        this.amount = new SimpleDoubleProperty(amount);
        this.interestRate = new SimpleDoubleProperty(interestRate);
        this.durationInMonths = new SimpleIntegerProperty(durationInMonths);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.status = new SimpleObjectProperty<>(status);
    }

    // JavaFX Property Methods
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

    public IntegerProperty durationInMonthsProperty() {
        return durationInMonths;
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public ObjectProperty<LoanStatus> statusProperty() {
        return status;
    }

    // Getters and Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public LoanType getLoanType() {
        return loanType.get();
    }

    public void setLoanType(LoanType loanType) {
        this.loanType.set(loanType);
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public double getInterestRate() {
        return interestRate.get();
    }

    public void setInterestRate(double interestRate) {
        this.interestRate.set(interestRate);
    }

    public int getDurationInMonths() {
        return durationInMonths.get();
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths.set(durationInMonths);
    }

    public int getClientId() {
        return clientId.get();
    }

    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }

    public LoanStatus getStatus() {
        return status.get();
    }

    public void setStatus(LoanStatus status) {
        this.status.set(status);
    }
}
