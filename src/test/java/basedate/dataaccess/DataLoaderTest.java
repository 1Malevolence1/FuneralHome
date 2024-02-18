package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import org.example.TestBuilderContract;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.validator.contract.ContractValidator;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {
    @Test
    public void test() throws VadilatorMenException, SQLException, ValidatorDataBase {
        Contract contract = TestBuilderContract.testBuildGood();
        ContractValidator contractValidator = new ContractValidator();
        contractValidator.checkAll(contract);
        DataLoader dataLoader = new DataLoader();
        dataLoader.loadAll();

    }
}