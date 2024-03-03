package basedate.dataaccess;

import basedate.connect.BuilderConnecting;
import basedate.dataaccess.contract.LoaderAllSumServices;
import basedate.dataaccess.contract.LoaderContract;
import basedate.dataaccess.service.LoaderService;
import basedate.dataaccess.service.ServiceInTheContractRepository;
import basedate.dataaccess.staff.WorkersInContractRepository;
import basedate.dataaccess.staff.StaffManager;
import org.example.answer.AnswerService;
import org.example.answer.AnswerStaff;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.exception.ValidatorService;

import java.sql.SQLException;

public class DataManager extends BuilderConnecting{


    public void loaderStaff(AnswerStaff answerStaff) throws ValidatorDataBase {

        StaffManager loaderStaff = new StaffManager();
        loaderObject(answerStaff.getStaff(), loaderStaff);
    }
    public void loaderService(AnswerService answerService) throws  ValidatorDataBase, ValidatorService {

        LoaderService loaderService = new LoaderService();
        loaderObject(answerService.getService(), loaderService);
    }

    public void loaderTheDeadMen(Contract contract) throws ValidatorDataBase  {
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

    public void loaderServiceInTheContract(Contract contract , ServiceInTheContractRepository serviceInTheContractRepository) throws VadilatorMenException, ValidatorDataBase {
        loaderObject(contract, serviceInTheContractRepository );
    }

    private void loaderWorkersInContract(Contract contract, WorkersInContractRepository loaderWorkersInContract) throws ValidatorDataBase {
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

    public void loadAll(Contract contract, ServiceInTheContractRepository serviceInTheContractRepository, WorkersInContractRepository loaderWorkersInContract) throws VadilatorMenException, ValidatorDataBase {

                loaderTheDeadMen(contract);
                loaderCostumer(contract);
                loaderContract(contract);
                loaderWorkersInContract(contract, loaderWorkersInContract);
                loaderServiceInTheContract(contract, serviceInTheContractRepository);
                loaderAllSumServices(contract);

    }



}
