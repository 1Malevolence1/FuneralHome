package basedate.dataaccess.service;



import basedate.dataaccess.Loader;
import org.example.domain.contract.Contract;
import org.example.domain.service.Service;
import org.example.exception.ValidatorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoaderService implements Loader<Service> {
    private final String REQUEST = "INSERT INTO services(" +
            " name_services, description_services, cost_services) " +
            " VALUES (?, ?, ?);";

    //@TODO добавить методы для весения данных

    @Override
    public void loader(Service service, Connection connection) throws SQLException, ValidatorDataBase {
        try(PreparedStatement stmt = connection.prepareStatement(REQUEST)){

            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescriptionService());
            stmt.setInt(3, service.getPriseService());

            stmt.executeUpdate();
        }
    }
}
