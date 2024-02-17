package basedate.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BuilderConnecting {

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Config.getProperties(Config.DB_URL),
                Config.getProperties(Config.DB_LOGIN),
                Config.getProperties(Config.DB_PASSWORD));
    }
}
