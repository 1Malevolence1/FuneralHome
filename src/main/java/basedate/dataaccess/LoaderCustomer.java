package basedate.dataaccess;

import org.example.domain.contract.Contract;
import org.example.exception.ValidatorDataBase;
import org.example.validator.email.MengerEmail;

import java.sql.*;

public class LoaderCustomer implements Loader<Contract>{

    private final String REQUEST = "INSERT INTO customers(" +
            " surname, name, patronymic, telephone, email)" +
            " VALUES (?, ?, ?, ?, ?);";
    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {
        try(PreparedStatement stmt = connection.prepareStatement(REQUEST,new String[]{"id"})){

            if(contract.getCustomers() != null) {

                MengerEmail mengerEmail = new MengerEmail(contract.getCustomers().getEmail());

                stmt.setString(1, contract.getCustomers().getSurname());
                stmt.setString(2, contract.getCustomers().getName());
                stmt.setString(3, contract.getCustomers().getPatronymic());
                stmt.setString(4, contract.getCustomers().getTelephone());
                stmt.setString(5, mengerEmail.fullEmail());

                stmt.executeUpdate();

                ResultSet gkRs = stmt.getGeneratedKeys();
                if (gkRs.next()) {
                    contract.getCustomers().setId(gkRs.getLong("id"));
                }

                gkRs.close();
            }

            else throw new ValidatorDataBase("Ошибка занесения данных клиента");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
