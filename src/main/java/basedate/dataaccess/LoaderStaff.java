package basedate.dataaccess;

import org.example.domain.person.Staff;
import org.example.exception.ValidatorDataBase;
import org.example.validator.email.MengerEmail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoaderStaff implements Loader<Staff> {
    private final String REQUEST = "INSERT INTO staff(" +
            " surname, name, patronymic, date_of_birthday, post, contact_phone_number)" +
            " VALUES ( ?, ?, ?, ?, ?, ?);";
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
}
