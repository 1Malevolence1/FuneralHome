package org.example.answer;

import org.example.TestBuildService;
import org.example.domain.service.Service;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorService;
import org.example.validator.service.ServiceValidator;

public class AnswerService {

    //  @TODO должнен будет получать объект откуда будут приходить данные
    public Service getService() throws  ValidatorService {
        ServiceValidator serviceValidator = new ServiceValidator();
         return serviceValidator.check(TestBuildService.service());
    }
}
