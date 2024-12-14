package financeflow.controllers.accounts;

import financeflow.models.accounts.Loan;
import financeflow.services.accounts.LoanService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class LoanController {

    @FXML
    private TableView<Loan> loanTable;

    @FXML
    private TableColumn<Loan, Integer> idColumn;

    @FXML
    private TableColumn<Loan, String> loanTypeColumn;

    @FXML
    private TableColumn<Loan, Double> amountColumn;

    @FXML
    private TableColumn<Loan, Double> interestRateColumn;

    @FXML
    private TableColumn<Loan, Integer> durationColumn;

    @FXML
    private TableColumn<Loan, String> clientColumn;

    @FXML
    private TableColumn<Loan, String> statusColumn;

    @FXML
    private TextField searchField;

    private final LoanService loanService = new LoanService();

    @FXML
    public void initialize() {
        initializeTableColumns();
        loadLoans();
        setupSearch();
    }

    private void initializeTableColumns() {
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        loanTypeColumn.setCellValueFactory(data -> data.getValue().loanTypeProperty().asString());
        amountColumn.setCellValueFactory(data -> data.getValue().amountProperty().asObject());
        interestRateColumn.setCellValueFactory(data -> data.getValue().interestRateProperty().asObject());
        durationColumn.setCellValueFactory(data -> data.getValue().durationProperty().asObject());
        clientColumn.setCellValueFactory(data -> data.getValue().clientNameProperty());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty().asString());
    }

    private void loadLoans() {
        List<Loan> loans = loanService.getAllLoans();
        loanTable.setItems(FXCollections.observableArrayList(loans));
    }

    private void setupSearch() {
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Loan> filteredLoans = loanService.searchLoans(newValue);
            loanTable.setItems(FXCollections.observableArrayList(filteredLoans));
        });
    }

    @FXML
    private void handleAddLoan() {
        // Logic to open add loan dialog
    }

    @FXML
    private void handleEditLoan() {
        // Logic to edit selected loan
    }

    @FXML
    private void handleDeleteLoan() {
        // Logic to delete selected loan
    }
}
