package basedate.dataaccess.contract;

import basedate.dataaccess.Loader;
import org.example.domain.contract.Contract;
import org.example.domain.service.ServiceInTheContract;
import org.example.exception.ValidatorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoaderAllSumServices implements Loader<Contract> {


    private final String REQUEST = "UPDATE contracts SET " +
            " cost_service = ? " +
            " WHERE id = ?;";


    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {
        try (PreparedStatement stmt = connection.prepareStatement(REQUEST)){
            stmt.setInt(1, contract.getAllSumServices());
            stmt.setLong(2, contract.getId());

            stmt.executeUpdate();
        }
    }
}
