package basedate.dataaccess.staff;

import basedate.dataaccess.Loader;
import org.example.domain.person.Staff;
import org.example.exception.ValidatorDataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffManager implements Loader<Staff> {
    private final String REQUEST = "INSERT INTO staff(" +
            " surname, name, patronymic, date_of_birthday, post, contact_phone_number)" +
            " VALUES ( ?, ?, ?, ?, ?, ?);";
    private final String GET_STAFF = "SELECT id, surname, name, patronymic, date_of_birthday, post, contact_phone_number " +
            "FROM staff WHERE id = ?;";
    @Override
    public void loader(Staff staff, Connection connection) throws SQLException, ValidatorDataBase {
        try(PreparedStatement stmt = connection.prepareStatement(REQUEST)) {

            if(staff != null) {

                stmt.setString(1,staff.getSurname());
                stmt.setString(2,staff.getName());
                stmt.setString(3,staff.getPatronymic());
                stmt.setDate(4, Date.valueOf(staff.getDateOfBirthday()));
                stmt.setString(5,staff.getPost());
                stmt.setString(6,staff.getTelephone());

                stmt.executeUpdate();
            }

            else throw new ValidatorDataBase("Ошибка в даннхы работника");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Staff> findStaff(String  massive, Connection connection) throws SQLException {
        List<Staff> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(GET_STAFF)){
            List<Long> listId = splitIdStaff(massive);
            for (Long id: listId
            ) {
                stmt.setLong(1,id);

                ResultSet rs = stmt.executeQuery();
                if (!rs.next()) {
                    throw new SQLException("Service not found for ID: " + id);
                }
                do {
                    Staff staff = new Staff(
                            rs.getString("surname"),
                                    rs.getString("name"),
                                    rs.getString("patronymic"),
                                    rs.getDate("date_of_birthday").toLocalDate(),
                                    rs.getString("post"),
                                    rs.getString("contact_phone_number"));
                    staff.setId(rs.getLong("id"));
                    list.add(staff);
                } while (rs.next());
            }
        } return list;
    }


    private List<Long> splitIdStaff(String massive) {
        String[] array = massive.split(",");

        List<Long> listId = new ArrayList<>();

        for (String item : array
        ) {
            listId.add(Long.parseLong(item));
        }

        return listId;
    }
}
