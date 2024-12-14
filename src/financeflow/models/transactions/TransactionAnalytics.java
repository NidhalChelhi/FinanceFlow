package financeflow.models.transactions;

import javafx.beans.property.*;
import financeflow.models.enums.TransactionType;

public class TransactionAnalytics {
    private final IntegerProperty totalTransactions;
    private final DoubleProperty totalAmount;
    private final DoubleProperty averageTransactionValue;
    private final ObjectProperty<TransactionType> mostFrequentTransactionType;

    public TransactionAnalytics(int totalTransactions, double totalAmount, double averageTransactionValue, TransactionType mostFrequentTransactionType) {
        this.totalTransactions = new SimpleIntegerProperty(totalTransactions);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.averageTransactionValue = new SimpleDoubleProperty(averageTransactionValue);
        this.mostFrequentTransactionType = new SimpleObjectProperty<>(mostFrequentTransactionType);
    }

    // Property methods
    public IntegerProperty totalTransactionsProperty() { return totalTransactions; }
    public DoubleProperty totalAmountProperty() { return totalAmount; }
    public DoubleProperty averageTransactionValueProperty() { return averageTransactionValue; }
    public ObjectProperty<TransactionType> mostFrequentTransactionTypeProperty() { return mostFrequentTransactionType; }

    // Getters and setters
    public int getTotalTransactions() { return totalTransactions.get(); }
    public void setTotalTransactions(int totalTransactions) { this.totalTransactions.set(totalTransactions); }
    public double getTotalAmount() { return totalAmount.get(); }
    public void setTotalAmount(double totalAmount) { this.totalAmount.set(totalAmount); }
    public double getAverageTransactionValue() { return averageTransactionValue.get(); }
    public void setAverageTransactionValue(double averageTransactionValue) { this.averageTransactionValue.set(averageTransactionValue); }
    public TransactionType getMostFrequentTransactionType() { return mostFrequentTransactionType.get(); }
    public void setMostFrequentTransactionType(TransactionType mostFrequentTransactionType) { this.mostFrequentTransactionType.set(mostFrequentTransactionType); }
}
