package basedate.dataaccess.contract;

import basedate.dataaccess.Loader;
import org.example.domain.contract.Contract;
import org.example.exception.ValidatorDataBase;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoaderContract implements Loader<Contract> {
    private final String REQUEST = "INSERT INTO contracts(" +
            " id_the_dead_man, id_customer, date_conclusion_contract, cost_service, status_contract) " +
            "VALUES (?, ?, ?, ?, ?, ?);";

    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {
        try(PreparedStatement stmt = connection.prepareStatement(REQUEST)){

            stmt.setLong(1, contract.getTheDeadMen().getId());
            stmt.setLong(2, contract.getCustomers().getId());
            stmt.setDate(4, Date.valueOf(LocalDate.now()));
            stmt.setInt(5, 5);
            stmt.setBoolean(5, true);
        }
    }
}
