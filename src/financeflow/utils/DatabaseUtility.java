package financeflow.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {

    public static Connection getConnection() throws SQLException {
        String databasePath = new File("data/financeflow.db").getAbsolutePath();
        String databaseUrl = "jdbc:sqlite:" + databasePath;

        return DriverManager.getConnection(databaseUrl);
    }
}
