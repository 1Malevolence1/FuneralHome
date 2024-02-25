package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import basedate.dataaccess.service.LoaderService;
import org.example.answer.AnswerContract;
import org.example.answer.AnswerService;
import org.example.answer.AnswerStaff;
import org.example.domain.contract.Contract;
import org.example.domain.service.Service;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.exception.ValidatorService;

import java.sql.SQLException;

public class DataLoader {


    public void loaderStaff() throws ValidatorDataBase {
        AnswerStaff answerStaff = new AnswerStaff();
        LoaderStaff loaderStaff = new LoaderStaff();
        loaderObject(answerStaff.getStaff(), loaderStaff);
    }
    public void loaderService() throws  ValidatorDataBase, ValidatorService {
        AnswerService answerService = new AnswerService();
        LoaderService loaderService = new LoaderService();
        loaderObject(answerService.getService(), loaderService);
    }

    public void loaderTheDeadMen() throws VadilatorMenException, ValidatorDataBase  {
        LoaderTheDeadMen loaderTheDeadMen = new LoaderTheDeadMen();
        loaderObject(getContract(), loaderTheDeadMen);
    }

    public void loaderCostumer() throws VadilatorMenException, ValidatorDataBase {
        LoaderCustomer loaderCustomer = new LoaderCustomer();
        loaderObject(getContract(), loaderCustomer);
    }
    private <T, E> void loaderObject(T object, Loader<E> loader) throws ValidatorDataBase{

        try {
           Loader item = loader;
           item.loader( object, BuilderConnecting.getConnection());
        }
        catch (SQLException e){
            throw new ValidatorDataBase("не удалось загрузить данные: " + object.getClass().getName());
        }
    }

    public void loadAll() throws VadilatorMenException, ValidatorDataBase {
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