package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import org.example.TestBuilderContract;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.validator.contract.ContractValidator;

import java.sql.Connection;
import java.sql.SQLException;

public class DataLoader {

    private ContractValidator validator;

    public DataLoader(ContractValidator validator) {
        this.validator = validator;
    }

    public void loadTheDeadMen() throws VadilatorMenException, ValidatorDataBase, SQLException {
        try {
        LoaderTheDeadMen loaderTheDeadMen = new LoaderTheDeadMen();
        loaderTheDeadMen.loader(getContract(), BuilderConnecting.getConnection());
    }
        catch (SQLException e){
            throw new ValidatorDataBase("Не удалось загрусть данные покойника");
        }
    }

    /*public void allLoad(Object object) throws VadilatorMenException, ValidatorDataBase, SQLException {
        try {
            Loader loader = object;
            loader.loader(getContract(), BuilderConnecting.getConnection());
        }
        catch (SQLException e){
            throw new ValidatorDataBase("Не удалось загрусть данные покойника");
        }
    }*/




    // Получаем класс контракт
    private Contract getContract() throws VadilatorMenException {
        return  validator.checkAll(TestBuilderContract.testBuildGood());
    }


}
