package web;

import basedate.connect.PoolConnectBuilder;
import basedate.dataaccess.DataManager;
import basedate.dataaccess.service.ServiceInTheContractRepository;
import basedate.dataaccess.service.ServiceManager;
import basedate.dataaccess.staff.StaffManager;
import basedate.dataaccess.staff.WorkersInContractRepository;
import org.example.answer.AnswerContract;
import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.domain.email.Email;
import org.example.domain.person.Customer;
import org.example.domain.person.Staff;
import org.example.domain.person.TheDeadMen;
import org.example.domain.service.Service;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.validator.email.MengerEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/contract")
public class WEBContract extends HttpServlet {

   private DataManager dataManager;
   private ServiceInTheContractRepository serviceInTheContractRepository;
   private WorkersInContractRepository loaderWorkersInContract;
   private PoolConnectBuilder poolConnectBuilder;

    public void init() throws ServletException {
        poolConnectBuilder = new PoolConnectBuilder();

        dataManager = new DataManager();
        dataManager.setConnectBuilder(poolConnectBuilder);

        serviceInTheContractRepository = new ServiceInTheContractRepository();
        serviceInTheContractRepository.setConnectBuilder(poolConnectBuilder);

        loaderWorkersInContract = new WorkersInContractRepository();
        loaderWorkersInContract.setConnectBuilder(poolConnectBuilder);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Contract contract = new Contract();
        AnswerContract answerContract = new AnswerContract();


        serviceInTheContractRepository.setMassive(getMassiveServices(request));
        loaderWorkersInContract.setMassive(getMassiveStaff(request));



        contract.setTheDeadMen(сreationTheDeadMen(request));
        contract.setCustomers(сreationCustomer(request));




        try {
            if(answerContract.getContract(contract) == null){
                response.getWriter().write("Error in the data");
            }
            else {
                dataManager.loadAll(answerContract.getContract(contract), serviceInTheContractRepository, loaderWorkersInContract);
                response.getWriter().write("The contract has been successfully created");
            }
        } catch (VadilatorMenException e) {
            throw new RuntimeException(e);
        } catch (ValidatorDataBase e) {
            throw new RuntimeException(e);
        }


    }

    private TheDeadMen сreationTheDeadMen(HttpServletRequest request){

        TheDeadMen theDeadMen = new TheDeadMen(
                request.getParameter("surnameTheDeadMen"),
                request.getParameter("nameTheDeadMen"),
                request.getParameter("patronymicTheDeadMen"),
                LocalDate.parse(request.getParameter("dateOfBirthdayTheDeadMen"), DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalDate.parse(request.getParameter("dateOfDeadTheDeadMen"), DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        );
        return theDeadMen;
    }

    private Customer сreationCustomer(HttpServletRequest request){
        MengerEmail mengerEmail = new MengerEmail();

        Customer customer = new Customer(
                request.getParameter("surnameCustomer"),
                request.getParameter("nameCustomer"),
                request.getParameter("patronymicCustomer"),
                request.getParameter("telephoneCustomer"),
                mengerEmail.splitEmail(getStringEmail(request))
        );
        return customer;
    }


    private String getMassiveServices(HttpServletRequest request){
        return request.getParameter("services");
    }

    private String getMassiveStaff(HttpServletRequest request){
        return request.getParameter("staff");
    }

    private String getStringEmail(HttpServletRequest request){
        return  request.getParameter("email");
    }
}


