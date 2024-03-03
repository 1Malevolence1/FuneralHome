package basedate.dataaccess.staff;

import org.example.domain.contract.Contract;
import org.example.domain.person.Staff;

import java.util.List;

public class WorkersInContract {
    private Contract contract;

    private List<Staff> staff;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }
}
