package financeflow.models.employees;

import javafx.beans.property.*;

public class BranchPerformance {
    private final IntegerProperty branchId;
    private final DoubleProperty totalRevenue;
    private final IntegerProperty totalAccounts;
    private final DoubleProperty totalLoans;

    public BranchPerformance(int branchId, double totalRevenue, int totalAccounts, double totalLoans) {
        this.branchId = new SimpleIntegerProperty(branchId);
        this.totalRevenue = new SimpleDoubleProperty(totalRevenue);
        this.totalAccounts = new SimpleIntegerProperty(totalAccounts);
        this.totalLoans = new SimpleDoubleProperty(totalLoans);
    }

    // Property methods
    public IntegerProperty branchIdProperty() { return branchId; }
    public DoubleProperty totalRevenueProperty() { return totalRevenue; }
    public IntegerProperty totalAccountsProperty() { return totalAccounts; }
    public DoubleProperty totalLoansProperty() { return totalLoans; }

    // Getters and setters
    public int getBranchId() { return branchId.get(); }
    public void setBranchId(int branchId) { this.branchId.set(branchId); }
    public double getTotalRevenue() { return totalRevenue.get(); }
    public void setTotalRevenue(double totalRevenue) { this.totalRevenue.set(totalRevenue); }
    public int getTotalAccounts() { return totalAccounts.get(); }
    public void setTotalAccounts(int totalAccounts) { this.totalAccounts.set(totalAccounts); }
    public double getTotalLoans() { return totalLoans.get(); }
    public void setTotalLoans(double totalLoans) { this.totalLoans.set(totalLoans); }
}
