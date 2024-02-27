package basedate.dataaccess.contract;

import basedate.dataaccess.Loader;
import org.example.domain.contract.Contract;
import org.example.exception.ValidatorDataBase;

import java.sql.*;
import java.time.LocalDate;

public class LoaderContract implements Loader<Contract> {
    private final String REQUEST = "INSERT INTO contracts(" +
            " id_the_dead_man, id_customer, date_conclusion_contract, cost_service, status_contract) " +
            "VALUES (?, ?, ?, ?, ?);";

    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {
        try (PreparedStatement stmt = connection.prepareStatement(REQUEST, new String[]{"id"})) {

            stmt.setLong(1, contract.getTheDeadMen().getId());
            stmt.setLong(2, contract.getCustomers().getId());
            stmt.setDate(3, Date.valueOf(LocalDate.now()));
            stmt.setDouble(4, contract.getAllSumServices());
            stmt.setBoolean(5, true);

            stmt.executeUpdate();
            ResultSet gkRs = stmt.getGeneratedKeys();
            if(gkRs.next()) {
                contract.setId(gkRs.getLong(1));
            }
        } catch (SQLException exception) {
            exception.getMessage();
        }
    }

}
