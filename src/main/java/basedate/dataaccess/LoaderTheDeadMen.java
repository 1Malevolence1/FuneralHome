package basedate.dataaccess;

import org.example.domain.contract.Contract;

import org.example.exception.ValidatorDataBase;

import java.sql.*;

public class LoaderTheDeadMen  implements Loader<Contract>{

    private final String REQUEST = "INSERT INTO thedeadman(" +
            "surname, name, patronymic, date_of_birthday, date_of_death) " +
            "VALUES (?, ?, ?, ?, ?);";
    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {

            try(PreparedStatement stmt = connection.prepareStatement(REQUEST,  new String[]{"id"})) {


                if(contract.getTheDeadMen() != null) {

                    stmt.setString(1, contract.getTheDeadMen().getSurname());
                    stmt.setString(2, contract.getTheDeadMen().getName());
                    stmt.setString(3, contract.getTheDeadMen().getPatronymic());
                    stmt.setDate(4, Date.valueOf(contract.getTheDeadMen().getDateOfBirthday()));
                    stmt.setDate(5, Date.valueOf(contract.getTheDeadMen().getDateOfDead()));

                    stmt.executeUpdate();

                    ResultSet gkRs = stmt.getGeneratedKeys();

                    if(gkRs.next()) {
                        contract.getTheDeadMen().setId(gkRs.getLong(1));
                    }
                    gkRs.close();

                }

                else throw new ValidatorDataBase("Ошибка занесения данных покойника");

            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}
