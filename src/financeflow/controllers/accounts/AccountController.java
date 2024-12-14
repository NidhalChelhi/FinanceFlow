package financeflow.controllers.accounts;

import financeflow.models.accounts.Account;
import financeflow.models.enums.AccountStatus;
import financeflow.models.enums.AccountType;
import financeflow.services.accounts.AccountService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class AccountController {
    @FXML
    private TableView<Account> accountTable;

    @FXML
    private TableColumn<Account, Integer> idColumn;

    @FXML
    private TableColumn<Account, String> accountNumberColumn;

    @FXML
    private TableColumn<Account, String> accountTypeColumn;

    @FXML
    private TableColumn<Account, Double> balanceColumn;

    @FXML
    private TableColumn<Account, String> statusColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField searchField;

    private final AccountService accountService;
    private ObservableList<Account> accounts;

    public AccountController() {
        this.accountService = new AccountService();
    }

    @FXML
    public void initialize() {
        initializeTable();
        loadAccounts();

        // Add search functionality
        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterAccounts(newValue));
    }

    private void initializeTable() {
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        accountNumberColumn.setCellValueFactory(data -> data.getValue().accountNumberProperty());
        accountTypeColumn.setCellValueFactory(data -> data.getValue().accountTypeProperty().asString());
        balanceColumn.setCellValueFactory(data -> data.getValue().balanceProperty().asObject());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty().asString());
    }

    private void loadAccounts() {
        List<Account> accountList = accountService.getAllAccounts();
        accounts = FXCollections.observableArrayList(accountList);
        accountTable.setItems(accounts);
    }

    private void filterAccounts(String query) {
        if (query == null || query.isEmpty()) {
            accountTable.setItems(accounts);
        } else {
            ObservableList<Account> filteredAccounts = accounts.filtered(account ->
                    account.getAccountNumber().contains(query) ||
                            account.getAccountType().toString().toLowerCase().contains(query.toLowerCase()) ||
                            account.getStatus().toString().toLowerCase().contains(query.toLowerCase())
            );
            accountTable.setItems(filteredAccounts);
        }
    }

    @FXML
    private void handleAddAccount() {
        // Open Add Account Popup
    }

    @FXML
    private void handleEditAccount() {
        // Open Edit Account Popup
    }

    @FXML
    private void handleDeleteAccount() {
        // Delete Account
    }
}
