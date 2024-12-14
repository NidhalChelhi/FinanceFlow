package financeflow.dao.accounts;

import financeflow.models.accounts.CreditLimit;
import financeflow.utils.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreditLimitDAO {

    public List<CreditLimit> findAll() {
        List<CreditLimit> creditLimits = new ArrayList<>();
        String query = "SELECT * FROM credit_limits";

        try (Connection connection = DatabaseUtility.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                creditLimits.add(mapResultSetToCreditLimit(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creditLimits;
    }

    public CreditLimit findById(int id) {
        String query = "SELECT * FROM credit_limits WHERE id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToCreditLimit(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(CreditLimit creditLimit) {
        String query = "INSERT INTO credit_limits (client_id, credit_limit, used_credit, available_credit) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, creditLimit.getClientId());
            statement.setDouble(2, creditLimit.getCreditLimit());
            statement.setDouble(3, creditLimit.getUsedCredit());
            statement.setDouble(4, creditLimit.getAvailableCredit());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(CreditLimit creditLimit) {
        String query = "UPDATE credit_limits SET credit_limit = ?, used_credit = ?, available_credit = ? " +
                "WHERE id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, creditLimit.getCreditLimit());
            statement.setDouble(2, creditLimit.getUsedCredit());
            statement.setDouble(3, creditLimit.getAvailableCredit());
            statement.setInt(4, creditLimit.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM credit_limits WHERE id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private CreditLimit mapResultSetToCreditLimit(ResultSet resultSet) throws SQLException {
        CreditLimit creditLimit = new CreditLimit();
        creditLimit.setId(resultSet.getInt("id"));
        creditLimit.setClientId(resultSet.getInt("client_id"));
        creditLimit.setCreditLimit(resultSet.getDouble("credit_limit"));
        creditLimit.setUsedCredit(resultSet.getDouble("used_credit"));
        creditLimit.setAvailableCredit(resultSet.getDouble("available_credit"));
        return creditLimit;
    }
}
