package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import basedate.dataaccess.contract.LoaderAllSumServices;
import basedate.dataaccess.contract.LoaderContract;
import basedate.dataaccess.service.LoaderService;
import basedate.dataaccess.service.ServiceInTheContractRepository;
import basedate.dataaccess.staff.LoaderWorkersInContract;
import basedate.dataaccess.staff.StaffManager;
import org.example.answer.AnswerContract;
import org.example.answer.AnswerService;
import org.example.answer.AnswerStaff;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.exception.ValidatorService;

import java.sql.SQLException;

public class DataManager extends BuilderConnecting{


    public void loaderStaff() throws ValidatorDataBase {
        AnswerStaff answerStaff = new AnswerStaff();
        StaffManager loaderStaff = new StaffManager();
        loaderObject(answerStaff.getStaff(), loaderStaff);
    }
    public void loaderService(AnswerService answerService) throws  ValidatorDataBase, ValidatorService {

        LoaderService loaderService = new LoaderService();
        loaderObject(answerService.getService(), loaderService);
    }

    public void loaderTheDeadMen(Contract contract) throws VadilatorMenException, ValidatorDataBase  {
        LoaderTheDeadMen loaderTheDeadMen = new LoaderTheDeadMen();
        loaderObject(contract, loaderTheDeadMen);
    }

    public void loaderCostumer(Contract contract) throws VadilatorMenException, ValidatorDataBase {
        LoaderCustomer loaderCustomer = new LoaderCustomer();
        loaderObject(contract, loaderCustomer);
    }

    public void loaderContract(Contract contract) throws VadilatorMenException, ValidatorDataBase {
        LoaderContract loaderContract = new LoaderContract();
        loaderObject(contract, loaderContract);
    }

    public void loaderServiceInTheContract(Contract contract) throws VadilatorMenException, ValidatorDataBase {
        ServiceInTheContractRepository serviceInTheContractRepository = new ServiceInTheContractRepository();
        loaderObject(contract,serviceInTheContractRepository );
    }

    private void loaderWorkersInContract(Contract contract) throws ValidatorDataBase {
        LoaderWorkersInContract loaderWorkersInContract = new LoaderWorkersInContract();
        loaderObject(contract, loaderWorkersInContract);
    }
    private <T, E> void loaderObject(T object, Loader<E> loader) throws ValidatorDataBase{

        try {
           Loader item = loader;
           item.loader( object, getConnection());
        }
        catch (SQLException e){
            throw new ValidatorDataBase("не удалось загрузить данные: " + object.getClass().getName());
        }
    }

    private void loaderAllSumServices(Contract contract) throws ValidatorDataBase {
        LoaderAllSumServices loaderAllSumServices = new LoaderAllSumServices();
        loaderObject(contract, loaderAllSumServices);
    }

    public void loadAll() throws VadilatorMenException, ValidatorDataBase {
                Contract contract = getContract();
                loaderTheDeadMen(contract);
                loaderCostumer(contract);
                loaderContract(contract);
                loaderServiceInTheContract(contract);
                loaderAllSumServices(contract);
                loaderWorkersInContract(contract);
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
