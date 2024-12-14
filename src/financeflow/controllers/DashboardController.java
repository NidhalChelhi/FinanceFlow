package financeflow.controllers;
import financeflow.utils.NavigationUtility;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    private AnchorPane contentArea;


    @FXML
    public void initialize() {
        showAccountsPage();
    }

    @FXML
    private void showAccountsPage() {
        NavigationUtility.loadContent("/financeflow/views/accounts/AccountView.fxml", contentArea);
    }

    @FXML
    private void showLoansPage() {
        NavigationUtility.loadContent("/financeflow/views/accounts/LoanView.fxml", contentArea);
    }

    @FXML
    private void showClientsPage() {
        NavigationUtility.loadContent("/financeflow/views/clients/ClientsView.fxml", contentArea);
    }

    @FXML
    private void showTransactionsPage() {
        NavigationUtility.loadContent("/financeflow/views/transactions/TransactionsView.fxml", contentArea);
    }

    @FXML
    private void showEmployeesPage() {
        NavigationUtility.loadContent("/financeflow/views/employees/EmployeesView.fxml", contentArea);
    }

    @FXML
    private void handleLogout() {
        Stage currentStage = (Stage) contentArea.getScene().getWindow();
        NavigationUtility.navigateTo("/financeflow/views/auth/LoginView.fxml", currentStage, "FinanceFlow - Login");
    }
}
