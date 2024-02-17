package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import org.example.TestBuilderContract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.validator.contract.ContractValidator;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class Loader {


    @Test
    public void test() throws VadilatorMenException, SQLException, ValidatorDataBase {
        ContractValidator contractValidator = new ContractValidator();
        LoaderTheDeadMen loaderTheDeadMen = new LoaderTheDeadMen();
        loaderTheDeadMen.loader(contractValidator.checkAll(TestBuilderContract.testBuildGood()), BuilderConnecting.getConnection());

    }
}