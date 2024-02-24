package basedate.dataaccess.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoaderService {
    private final String REQUEST = "INSERT INTO services(" +
            " name_services, description_services, cost_services) " +
            " VALUES (?, ?, ?);";

    //@TODO добавить методы для весения данных
    public void loaderService(Connection connection) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement(REQUEST)){

            stmt.setString(1, "Строка для название услуги");
            stmt.setString(2, "Строка для описание услуги");
            stmt.setString(3, "Строка для цены услуги");

            stmt.executeUpdate();
        }
    }
}
