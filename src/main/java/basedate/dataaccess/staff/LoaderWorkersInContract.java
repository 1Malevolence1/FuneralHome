package basedate.dataaccess.staff;

import basedate.connect.BuilderConnecting;
import basedate.dataaccess.Loader;
import org.example.TestBuiLdlStaffArray;
import org.example.domain.contract.Contract;
import org.example.domain.person.Staff;
import org.example.domain.service.Service;
import org.example.exception.ValidatorDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoaderWorkersInContract implements Loader<Contract> {
    private final String REQUEST = "INSERT INTO workersincontract( " +
            " id_contract, id_staff) " +
            " VALUES (?, ?);";
    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {
            StaffManager staffManager = new StaffManager();
            WorkersInContract workersInContract = new WorkersInContract();
        //    workersInContract.setStaff(staffManager.findStaff(TestBuiLdlStaffArray.getArraysStaff(), BuilderConnecting.getConnection()));


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

