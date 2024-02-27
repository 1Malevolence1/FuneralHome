package basedate.dataaccess.service;

import basedate.connect.BuilderConnecting;
import org.example.TestServicesInTheContract;
import org.example.domain.service.Service;
import org.example.domain.service.ServiceInTheContract;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class ServiceRepositoryTest {

    @Test
    public void getServiceBaseDate() throws SQLException {
        ServiceInTheContract serviceInTheContract = new ServiceInTheContract();
        ServiceRepository serviceRepository = new ServiceRepository();
        serviceInTheContract.setServices(serviceRepository.findService(TestServicesInTheContract.getArraysService(), BuilderConnecting.getConnection()));

        for (Service item: serviceInTheContract.getServices()
             ) {
            System.out.println(item.getId() + " " + item.getNameService() + " " + item.getPriseService());
        }
    }
}