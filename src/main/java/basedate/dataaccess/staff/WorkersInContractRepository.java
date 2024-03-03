package basedate.dataaccess.staff;

import basedate.connect.BuilderConnecting;
import basedate.dataaccess.Loader;
import org.example.domain.contract.Contract;
import org.example.domain.person.Staff;
import org.example.exception.ValidatorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkersInContractRepository extends BuilderConnecting implements Loader<Contract> {
    private String massive;

    public String getMassive() {
        return massive;
    }

    public void setMassive(String massive) {
        this.massive = massive;
    }


    private final String REQUEST = "INSERT INTO workersincontract( " +
            " id_contract, id_staff) " +
            " VALUES (?, ?);";
    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {
            StaffManager staffManager = new StaffManager();
            WorkersInContract workersInContract = new WorkersInContract();
            workersInContract.setStaff(staffManager.findStaff(getMassive(),  getConnection() ));


        try (PreparedStatement stmt = connection.prepareStatement(REQUEST)) {

            for (Staff item : workersInContract.getStaff()
            ) {
                stmt.setLong(1, contract.getId());
                stmt.setLong(2, item.getId());

                stmt.executeUpdate();

            }
        }
    }
    }

