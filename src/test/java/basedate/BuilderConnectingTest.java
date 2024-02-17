package basedate;

import basedate.connect.BuilderConnecting;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

class BuilderConnectingTest {


    @Test
    public  void test() throws SQLException {
        Connection conn = BuilderConnecting.getConnection();
        boolean reachable = conn.isValid(100);
        System.out.println(reachable);

    }
}