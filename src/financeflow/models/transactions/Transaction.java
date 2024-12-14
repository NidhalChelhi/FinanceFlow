package financeflow.models.transactions;

import financeflow.models.enums.TransactionStatus;
import financeflow.models.enums.TransactionType;
import javafx.beans.property.*;

public class Transaction {
    private final IntegerProperty id;
    private final ObjectProperty<TransactionType> transactionType;
    private final DoubleProperty amount;
    private final IntegerProperty accountId;
    private final IntegerProperty recipientAccountId; // Nullable for non-transfer transactions
    private final ObjectProperty<TransactionStatus> status;

    public Transaction(int id, TransactionType transactionType, double amount, int accountId, Integer recipientAccountId, TransactionStatus status) {
        this.id = new SimpleIntegerProperty(id);
        this.transactionType = new SimpleObjectProperty<>(transactionType);
        this.amount = new SimpleDoubleProperty(amount);
        this.accountId = new SimpleIntegerProperty(accountId);
        this.recipientAccountId = new SimpleIntegerProperty(recipientAccountId);
        this.status = new SimpleObjectProperty<>(status);
    }

    // JavaFX Property Methods
    public IntegerProperty idProperty() {
        return id;
    }

    public ObjectProperty<TransactionType> transactionTypeProperty() {
        return transactionType;
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public IntegerProperty accountIdProperty() {
        return accountId;
    }

    public IntegerProperty recipientAccountIdProperty() {
        return recipientAccountId;
    }

    public ObjectProperty<TransactionStatus> statusProperty() {
        return status;
    }

    // Getters and Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public TransactionType getTransactionType() {
        return transactionType.get();
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType.set(transactionType);
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public int getAccountId() {
        return accountId.get();
    }

    public void setAccountId(int accountId) {
        this.accountId.set(accountId);
    }

    public int getRecipientAccountId() {
        return recipientAccountId.get();
    }

    public void setRecipientAccountId(int recipientAccountId) {
        this.recipientAccountId.set(recipientAccountId);
    }

    public TransactionStatus getStatus() {
        return status.get();
    }

    public void setStatus(TransactionStatus status) {
        this.status.set(status);
    }
}
