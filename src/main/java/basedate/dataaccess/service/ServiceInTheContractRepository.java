package basedate.dataaccess.service;

import basedate.dataaccess.Loader;
import org.example.TestServicesInTheContract;
import org.example.domain.contract.Contract;
import org.example.domain.service.Service;
import org.example.exception.ValidatorDataBase;
import org.example.domain.service.ServiceInTheContract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceInTheContractRepository implements Loader<Contract> {

    private final String REQUEST = "INSERT INTO servicesinthecontract(" +
            " id_contract, id_service, count_service)" +
            " VALUES (?, ?, ?);";


    @Override
    public void loader(Contract contract, Connection connection) throws SQLException, ValidatorDataBase {

        ServiceManager serviceRepository = new ServiceManager();
        ServiceInTheContract serviceInTheContract = new ServiceInTheContract();
        serviceInTheContract.setServices(serviceRepository.findService(TestServicesInTheContract.getArraysService(), connection));
        serviceInTheContract.setContract(contract);

        contract.setAllSumServices(serviceInTheContract.getAllSumService());

        try (PreparedStatement stmt = connection.prepareStatement(REQUEST)) {

            for (Service item : serviceInTheContract.getServices()
            ) {
                stmt.setLong(1, serviceInTheContract.getContract().getId());
                stmt.setLong(2, item.getId());
                stmt.setLong(3, serviceInTheContract.getCountService());

                stmt.executeUpdate();

            }
        }
    }
}

