package basedate.dataaccess.service;

import basedate.dataaccess.Loader;
import org.example.domain.contract.Contract;
import org.example.domain.service.Service;
import org.example.exception.ValidatorDataBase;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ServiceRepository implements Loader<Service> {
    private final String REQUEST = "INSERT INTO services(" +
            " name_services, description_services, cost_services) " +
            " VALUES (?, ?, ?);";


    private final String GET_SERVICE = "SELECT id, name_services, description_services, cost_services " +
            "FROM services WHERE id = ?";

    @Override
    public void loader(Service service, Connection connection) throws SQLException, ValidatorDataBase {
        try (PreparedStatement stmt = connection.prepareStatement(REQUEST)) {

            stmt.setString(1, service.getNameService());
            stmt.setString(2, service.getDescriptionService());
            stmt.setInt(3, service.getPriseService());

            stmt.executeUpdate();
        }
    }

    public List<Service> findService(String massive, Connection connection) throws SQLException {
        List<Service> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(GET_SERVICE)){
        List<Long> listId = splitService(massive);
            for (Long id: listId
                 ) {
                stmt.setLong(1,id);

                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    throw new SQLException("Service not found for ID: " + id);
                }
                do {
                    Service service = new Service(
                            rs.getString("name_services"),
                            rs.getString("description_services"),
                            rs.getInt("cost_services"));
                    service.setId(rs.getLong("id"));
                    list.add(service);
                } while (rs.next());
            }
    } return list;

}

    private List<Long> splitService(String massive) {
        String[] array = massive.split(",");

        List<Long> listId = new ArrayList<>();

        for (String item : array
        ) {
            listId.add(Long.parseLong(item));
        }

        return listId;
    }
}
