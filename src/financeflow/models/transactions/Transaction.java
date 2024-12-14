package financeflow.models.transactions;

import financeflow.models.enums.TransactionStatus;
import financeflow.models.enums.TransactionType;

public class Transaction {
    private int id;
    private TransactionType transactionType;
    private double amount;
    private int accountId;
    private Integer recipientAccountId; // Nullable for non-transfer transactions
    private TransactionStatus status;

    // Getters and setters omitted for brevity
}
