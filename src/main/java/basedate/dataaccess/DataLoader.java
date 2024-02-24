package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import basedate.dataaccess.service.LoaderService;
import org.example.TestBuilderContract;
import org.example.answer.AnswerContract;
import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.validator.contract.ContractValidator;

import java.sql.SQLException;
import java.util.List;

public class DataLoader {



    public void loaderService() throws SQLException {
        LoaderService loaderService = new LoaderService();
        loaderService.loaderService(BuilderConnecting.getConnection());
    }

    public void loaderTheDeadMen() throws VadilatorMenException, ValidatorDataBase, SQLException {
        loaderObject(getContract().getTheDeadMen());
    }

    public void loaderCostumer() throws VadilatorMenException, ValidatorDataBase, SQLException {
        loaderObject(getContract().getCustomers());
    }
    private void loaderObject(Object object) throws VadilatorMenException, ValidatorDataBase, SQLException {

        try {
            Loader item = (Loader) object;
            item.loader(getContract(), BuilderConnecting.getConnection());
        }
        catch (SQLException e){
            throw new ValidatorDataBase("не удалось загрузить данные: " + object.getClass().getName());
        }
    }

    public void loadAll() throws SQLException, VadilatorMenException, ValidatorDataBase {
                loaderTheDeadMen();
                loaderCostumer();
    }


    private Contract getContract() throws VadilatorMenException {
         AnswerContract answerContract = new AnswerContract();
        return answerContract.getContract();
    }


   /*
    private void loadsDataBase() throws SQLException, VadilatorMenException, ValidatorDataBase {
        for (Object index: implementationObjects()
             ) {
            allLoad(index);
        }
    }
    private List<Object> implementationObjects(){

        ListLoaders listLoaders = new ListLoaders();
        LoaderTheDeadMen loaderTheDeadMen = new LoaderTheDeadMen();
        listLoaders.addListLoader(loaderTheDeadMen);

        return listLoaders.getList();
    }

    public void allLoad(Object object) throws VadilatorMenException, ValidatorDataBase, SQLException {
        try {
            Loader loader = (Loader) object;
            loader.loader(getContract(), BuilderConnecting.getConnection());
        }
        catch (SQLException e){
            throw new ValidatorDataBase("Не удалось загрусть данные");
        }
    }
*/





}
