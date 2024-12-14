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
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

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

    public void insertOrUpdate(CreditLimit creditLimit) {
        String query = creditLimit.getId() == 0
                ? "INSERT INTO credit_limits (client_id, credit_limit, used_credit, available_credit) VALUES (?, ?, ?, ?)"
                : "UPDATE credit_limits SET client_id = ?, credit_limit = ?, used_credit = ?, available_credit = ? WHERE id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, creditLimit.getClientId());
            statement.setDouble(2, creditLimit.getCreditLimit());
            statement.setDouble(3, creditLimit.getUsedCredit());
            statement.setDouble(4, creditLimit.getAvailableCredit());

            if (creditLimit.getId() != 0) {
                statement.setInt(5, creditLimit.getId());
            }

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
        return new CreditLimit(
                resultSet.getInt("id"),
                resultSet.getInt("client_id"),
                resultSet.getDouble("credit_limit"),
                resultSet.getDouble("used_credit"),
                resultSet.getDouble("available_credit")
        );
    }
}
