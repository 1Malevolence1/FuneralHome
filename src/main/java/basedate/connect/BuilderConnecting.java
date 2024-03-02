package basedate.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BuilderConnecting implements ConnectBuilder {


    private ConnectBuilder connectBuilder;




    public void setConnectBuilder(ConnectBuilder connectBuilder) {
        this.connectBuilder = connectBuilder;
    }


    @Override
    public Connection getConnection() throws SQLException {
        return connectBuilder.getConnection();
    }
}
