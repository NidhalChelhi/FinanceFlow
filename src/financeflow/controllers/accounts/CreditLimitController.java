package financeflow.controllers.accounts;

import financeflow.models.accounts.CreditLimit;
import financeflow.services.accounts.CreditLimitService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CreditLimitController {

    @FXML
    private TableView<CreditLimit> creditLimitTable;

    @FXML
    private TableColumn<CreditLimit, Integer> idColumn;

    @FXML
    private TableColumn<CreditLimit, Integer> clientIdColumn;

    @FXML
    private TableColumn<CreditLimit, Double> creditLimitColumn;

    @FXML
    private TableColumn<CreditLimit, Double> usedCreditColumn;

    @FXML
    private TableColumn<CreditLimit, Double> availableCreditColumn;

    private final CreditLimitService creditLimitService = new CreditLimitService();
    private ObservableList<CreditLimit> creditLimits;

    @FXML
    public void initialize() {
        initializeTableColumns();
        loadCreditLimits();
    }

    private void initializeTableColumns() {
        idColumn.setCellValueFactory(data -> data.getValue().idProperty().asObject());
        clientIdColumn.setCellValueFactory(data -> data.getValue().clientIdProperty().asObject());
        creditLimitColumn.setCellValueFactory(data -> data.getValue().creditLimitProperty().asObject());
        usedCreditColumn.setCellValueFactory(data -> data.getValue().usedCreditProperty().asObject());
        availableCreditColumn.setCellValueFactory(data -> data.getValue().availableCreditProperty().asObject());
    }

    private void loadCreditLimits() {
        creditLimits = FXCollections.observableArrayList(creditLimitService.getAllCreditLimits());
        creditLimitTable.setItems(creditLimits);
    }

    public void handleAddCreditLimit(ActionEvent actionEvent) {
    }

    public void handleEditCreditLimit(ActionEvent actionEvent) {
    }

    public void handleDeleteCreditLimit(ActionEvent actionEvent) {
    }
}
