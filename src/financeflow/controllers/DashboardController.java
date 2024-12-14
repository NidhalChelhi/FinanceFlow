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
    private void showCreditLimitsPage() {
        NavigationUtility.loadContent("/financeflow/views/accounts/CreditLimitView.fxml", contentArea);
    }

    @FXML
    private void showClientInteractionsPage() {
        NavigationUtility.loadContent("/financeflow/views/clients/ClientInteractionsView.fxml", contentArea);
    }

    @FXML
    private void showClientPerformancePage() {
        NavigationUtility.loadContent("/financeflow/views/clients/PerformanceView.fxml", contentArea);
    }

    @FXML
    private void showTransactionAnalyticsPage() {
        NavigationUtility.loadContent("/financeflow/views/transactions/TransactionAnalyticsView.fxml", contentArea);
    }

    @FXML
    private void showAnalyticsDataPage() {
        NavigationUtility.loadContent("/financeflow/views/transactions/AnalyticsDataView.fxml", contentArea);
    }

    @FXML
    private void showBranchesPage() {
        NavigationUtility.loadContent("/financeflow/views/employees/BranchView.fxml", contentArea);
    }

    @FXML
    private void showBranchPerformancePage() {
        NavigationUtility.loadContent("/financeflow/views/employees/BranchPerformanceView.fxml", contentArea);
    }

    @FXML
    private void handleLogout() {
        Stage currentStage = (Stage) contentArea.getScene().getWindow();
        NavigationUtility.navigateTo("/financeflow/views/auth/LoginView.fxml", currentStage, "FinanceFlow - Login");
    }
}
