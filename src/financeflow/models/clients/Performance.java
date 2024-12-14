package financeflow.models.clients;

import javafx.beans.property.*;

public class Performance {
    private final IntegerProperty clientId;
    private final DoubleProperty totalSpending;
    private final IntegerProperty totalTransactions;
    private final DoubleProperty satisfactionRating;

    public Performance(int clientId, double totalSpending, int totalTransactions, double satisfactionRating) {
        this.clientId = new SimpleIntegerProperty(clientId);
        this.totalSpending = new SimpleDoubleProperty(totalSpending);
        this.totalTransactions = new SimpleIntegerProperty(totalTransactions);
        this.satisfactionRating = new SimpleDoubleProperty(satisfactionRating);
    }

    // Property methods
    public IntegerProperty clientIdProperty() { return clientId; }
    public DoubleProperty totalSpendingProperty() { return totalSpending; }
    public IntegerProperty totalTransactionsProperty() { return totalTransactions; }
    public DoubleProperty satisfactionRatingProperty() { return satisfactionRating; }

    // Getters and setters
    public int getClientId() { return clientId.get(); }
    public void setClientId(int clientId) { this.clientId.set(clientId); }
    public double getTotalSpending() { return totalSpending.get(); }
    public void setTotalSpending(double totalSpending) { this.totalSpending.set(totalSpending); }
    public int getTotalTransactions() { return totalTransactions.get(); }
    public void setTotalTransactions(int totalTransactions) { this.totalTransactions.set(totalTransactions); }
    public double getSatisfactionRating() { return satisfactionRating.get(); }
    public void setSatisfactionRating(double satisfactionRating) { this.satisfactionRating.set(satisfactionRating); }
}
