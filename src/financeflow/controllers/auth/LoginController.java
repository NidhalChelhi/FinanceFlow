package financeflow.controllers.auth;
import financeflow.utils.NavigationUtility;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;


    @FXML
    private void handleLogin() {


        Stage currentStage = (Stage) emailField.getScene().getWindow();
        NavigationUtility.navigateTo(
                "/financeflow/views/DashboardView.fxml",
                currentStage,
                "FinanceFlow - Dashboard"

        );

    }


}
