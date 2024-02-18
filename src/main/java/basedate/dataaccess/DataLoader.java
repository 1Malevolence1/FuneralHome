package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
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

    public void loadTheDeadMen() throws VadilatorMenException, ValidatorDataBase, SQLException {

        try {
        LoaderTheDeadMen loaderTheDeadMen = new LoaderTheDeadMen();
        loaderTheDeadMen.loader(getContract(), BuilderConnecting.getConnection());
    }
        catch (SQLException e){
            throw new ValidatorDataBase("Не удалось загрусть данные покойника");
        }
    }

    public void loadCostumer() throws VadilatorMenException, ValidatorDataBase, SQLException {
        AnswerContract answerContract = new AnswerContract();
        try {
            LoaderCustomer loaderCustomer = new LoaderCustomer();
            loaderCustomer.loader(answerContract.getContract(), BuilderConnecting.getConnection());
        }
        catch (SQLException e){
            throw new ValidatorDataBase("Не удалось загрусть данные клиента");
        }
    }

    public void loadAll() throws SQLException, VadilatorMenException, ValidatorDataBase {

        loadTheDeadMen();
        loadCostumer();
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



    // Получаем класс контракт



}
