package basedate.dataaccess.service;



import org.example.domain.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoaderService {
    private final String REQUEST = "INSERT INTO services(" +
            " name_services, description_services, cost_services) " +
            " VALUES (?, ?, ?);";

    //@TODO добавить методы для весения данных
    public void loaderService(Connection connection, Service service) throws SQLException {
        try(PreparedStatement stmt = connection.prepareStatement(REQUEST)){

            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescriptionService());
            stmt.setInt(3, service.getPriseService());

            stmt.executeUpdate();
        }
    }
}
