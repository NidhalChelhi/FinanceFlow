package financeflow.dao.accounts;

import financeflow.models.accounts.Account;
import financeflow.models.enums.AccountStatus;
import financeflow.models.enums.AccountType;
import financeflow.utils.DatabaseUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM accounts";

        try (Connection connection = DatabaseUtility.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                accounts.add(mapResultSetToAccount(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public Account findById(int id) {
        String query = "SELECT * FROM accounts WHERE id = ?";
        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return mapResultSetToAccount(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Account account) {
        String query = "INSERT INTO accounts (account_number, account_type, balance, client_id, branch_id, status) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, account.getAccountNumber());
            statement.setString(2, account.getAccountType().getDatabaseValue());
            statement.setDouble(3, account.getBalance());
            statement.setInt(4, account.getClientId());
            statement.setInt(5, account.getBranchId());
            statement.setString(6, account.getStatus().getDatabaseValue());

            int affectedRows = statement.executeUpdate();

            // Retrieve generated key (id)
            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        String query = "UPDATE accounts SET account_number = ?, account_type = ?, balance = ?, client_id = ?, branch_id = ?, status = ? WHERE id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, account.getAccountNumber());
            statement.setString(2, account.getAccountType().getDatabaseValue());
            statement.setDouble(3, account.getBalance());
            statement.setInt(4, account.getClientId());
            statement.setInt(5, account.getBranchId());
            statement.setString(6, account.getStatus().getDatabaseValue());
            statement.setInt(7, account.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM accounts WHERE id = ?";

        try (Connection connection = DatabaseUtility.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Account mapResultSetToAccount(ResultSet resultSet) throws SQLException {
        return new Account(
                resultSet.getInt("id"),
                resultSet.getString("account_number"),
                AccountType.fromDatabaseValue(resultSet.getString("account_type")),
                resultSet.getDouble("balance"),
                resultSet.getInt("client_id"),
                resultSet.getInt("branch_id"),
                AccountStatus.fromDatabaseValue(resultSet.getString("status"))
        );
    }
}
