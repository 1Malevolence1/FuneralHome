package org.example.answer;

import org.example.TestBuildStaffTest;
import org.example.domain.person.Staff;
import org.example.exception.ValidatorService;
import org.example.validator.person.StaffValidator;
import org.example.validator.service.ServiceValidator;

public class AnswerStaff {

    //  @TODO должнен будет получать объект откуда будут приходить данные
    public Staff getStaff()   {
        StaffValidator staffValidator = new StaffValidator();
        return staffValidator.check(TestBuildStaffTest.getStaff());
    }
}
