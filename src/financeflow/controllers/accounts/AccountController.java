package financeflow.controllers.accounts;

import financeflow.models.accounts.Account;
import financeflow.services.accounts.AccountService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    private final AccountService accountService = new AccountService();
    private ObservableList<Account> accounts;

    @FXML
    public void initialize() {
        initializeTableColumns();
        loadAccounts();
    }

    private void initializeTableColumns() {
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        accountNumberColumn.setCellValueFactory(data -> data.getValue().accountNumberProperty());
        accountTypeColumn.setCellValueFactory(data -> data.getValue().accountTypeProperty().asString());
        balanceColumn.setCellValueFactory(data -> data.getValue().balanceProperty().asObject());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty().asString());
    }

    private void loadAccounts() {
        accounts = FXCollections.observableArrayList(accountService.getAllAccounts());
        accountTable.setItems(accounts);
    }

    public void handleAddAccount(ActionEvent actionEvent) {
    }

    public void handleEditAccount(ActionEvent actionEvent) {
    }

    public void handleDeleteAccount(ActionEvent actionEvent) {
    }
}
