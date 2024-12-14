package financeflow.controllers.accounts;

import financeflow.models.accounts.Loan;
import financeflow.services.accounts.LoanService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private TableColumn<Loan, String> statusColumn;

    private final LoanService loanService = new LoanService();
    private ObservableList<Loan> loans;

    @FXML
    public void initialize() {
        initializeTableColumns();
        loadLoans();
    }

    private void initializeTableColumns() {
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        loanTypeColumn.setCellValueFactory(data -> data.getValue().loanTypeProperty().asString());
        amountColumn.setCellValueFactory(data -> data.getValue().amountProperty().asObject());
        interestRateColumn.setCellValueFactory(data -> data.getValue().interestRateProperty().asObject());
        durationColumn.setCellValueFactory(data -> data.getValue().durationInMonthsProperty().asObject());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty().asString());
    }

    private void loadLoans() {
        loans = FXCollections.observableArrayList(loanService.getAllLoans());
        loanTable.setItems(loans);
    }

    public void handleAddLoan(ActionEvent actionEvent) {
    }

    public void handleEditLoan(ActionEvent actionEvent) {
    }

    public void handleDeleteLoan(ActionEvent actionEvent) {
    }
}
