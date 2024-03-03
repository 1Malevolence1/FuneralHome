package org.example.answer;

import org.example.domain.person.Staff;
import org.example.validator.person.StaffValidator;

public class AnswerStaff {

    private Staff staff;

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    //  @TODO должнен будет получать объект откуда будут приходить данные
    public Staff getStaff()   {
        StaffValidator staffValidator = new StaffValidator();
        return staffValidator.check(staff);
    }
}
