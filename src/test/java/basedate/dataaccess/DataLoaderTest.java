package basedate.dataaccess;

import org.example.TestBuilderContract;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.exception.ValidatorService;
import org.example.validator.contract.ContractValidator;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class DataLoaderTest {
    @Test
    public void testContract() throws VadilatorMenException, SQLException, ValidatorDataBase {
        Contract contract = TestBuilderContract.testBuildGood();
        ContractValidator contractValidator = new ContractValidator();
        contractValidator.checkAll(contract);
        DataManager dataLoader = new DataManager();
        dataLoader.loadAll();

    }

    @Test
    public void testService() throws ValidatorDataBase, ValidatorService {
        DataManager dataLoader = new DataManager();
        dataLoader.loaderService();
    }

    @Test void testLoaderStaff() throws ValidatorDataBase {
        DataManager dataLoader = new DataManager();
        dataLoader.loaderStaff();
    }

   /* @Test
    void testVVV() throws VadilatorMenException, ValidatorDataBase {
        DataManager dataLoader = new DataManager();
        dataLoader.loaderServiceInTheContract();
    }*/
}