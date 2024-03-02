package basedate.connect;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolConnectBuilder implements ConnectBuilder{


    private DataSource dataSource;



    public PoolConnectBuilder() {
        returnDatasurs();
    }

    private DataSource returnDatasurs(){
        try {
            Context ctx = new InitialContext();
            this.dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/FuneralHome");
            return dataSource;
        } catch (NamingException var2) {

        }
        return null;
    }
    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
