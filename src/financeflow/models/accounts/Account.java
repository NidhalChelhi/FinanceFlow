package financeflow.models.accounts;

import financeflow.models.enums.AccountStatus;
import financeflow.models.enums.AccountType;
import javafx.beans.property.*;

public class Account {
    private final IntegerProperty id;
    private final StringProperty accountNumber;
    private final ObjectProperty<AccountType> accountType;
    private final DoubleProperty balance;
    private final IntegerProperty clientId;
    private final IntegerProperty branchId;
    private final ObjectProperty<AccountStatus> status;

    public Account(int id, String accountNumber, AccountType accountType, double balance, int clientId, int branchId, AccountStatus status) {
        this.id = new SimpleIntegerProperty(id);
        this.accountNumber = new SimpleStringProperty(accountNumber);
        this.accountType = new SimpleObjectProperty<>(accountType);
        this.balance = new SimpleDoubleProperty(balance);
        this.clientId = new SimpleIntegerProperty(clientId);
        this.branchId = new SimpleIntegerProperty(branchId);
        this.status = new SimpleObjectProperty<>(status);
    }

    // JavaFX Property Methods
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty accountNumberProperty() {
        return accountNumber;
    }

    public ObjectProperty<AccountType> accountTypeProperty() {
        return accountType;
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public IntegerProperty clientIdProperty() {
        return clientId;
    }

    public IntegerProperty branchIdProperty() {
        return branchId;
    }

    public ObjectProperty<AccountStatus> statusProperty() {
        return status;
    }

    // Getters and Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getAccountNumber() {
        return accountNumber.get();
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.set(accountNumber);
    }

    public AccountType getAccountType() {
        return accountType.get();
    }

    public void setAccountType(AccountType accountType) {
        this.accountType.set(accountType);
    }

    public double getBalance() {
        return balance.get();
    }

    public void setBalance(double balance) {
        this.balance.set(balance);
    }

    public int getClientId() {
        return clientId.get();
    }

    public void setClientId(int clientId) {
        this.clientId.set(clientId);
    }

    public int getBranchId() {
        return branchId.get();
    }

    public void setBranchId(int branchId) {
        this.branchId.set(branchId);
    }

    public AccountStatus getStatus() {
        return status.get();
    }

    public void setStatus(AccountStatus status) {
        this.status.set(status);
    }
}
