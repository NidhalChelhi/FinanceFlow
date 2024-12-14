package financeflow.dao.accounts;

import financeflow.models.accounts.Loan;
import financeflow.models.enums.LoanStatus;
import financeflow.models.enums.LoanType;
import financeflow.utils.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {

    public List<Loan> findAll() {
        List<Loan> loans = new ArrayList<>();
        String query = "SELECT * FROM loans";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                loans.add(mapResultSetToLoan(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loans;
    }

    public Loan findById(int id) {
        String query = "SELECT * FROM loans WHERE id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToLoan(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void save(Loan loan) {
        String query = loan.getId() == 0
                ? "INSERT INTO loans (loan_type, amount, interest_rate, duration_months, client_id, status) VALUES (?, ?, ?, ?, ?, ?)"
                : "UPDATE loans SET loan_type = ?, amount = ?, interest_rate = ?, duration_months = ?, client_id = ?, status = ? WHERE id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, loan.getLoanType().name());
            statement.setDouble(2, loan.getAmount());
            statement.setDouble(3, loan.getInterestRate());
            statement.setInt(4, loan.getDurationInMonths());
            statement.setInt(5, loan.getClientId());
            statement.setString(6, loan.getStatus().name());

            if (loan.getId() != 0) {
                statement.setInt(7, loan.getId());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM loans WHERE id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Loan mapResultSetToLoan(ResultSet resultSet) throws SQLException {
        return new Loan(
                resultSet.getInt("id"),
                LoanType.valueOf(resultSet.getString("loan_type")),
                resultSet.getDouble("amount"),
                resultSet.getDouble("interest_rate"),
                resultSet.getInt("duration_months"),
                resultSet.getInt("client_id"),
                LoanStatus.valueOf(resultSet.getString("status"))
        );
    }
}
