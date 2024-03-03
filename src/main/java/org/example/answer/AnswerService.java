package org.example.answer;

import org.example.TestBuildService;
import org.example.domain.service.Service;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorService;
import org.example.validator.service.ServiceValidator;

public class AnswerService {

    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    //  @TODO должнен будет получать объект откуда будут приходить данные
    public Service getService() throws  ValidatorService {
        ServiceValidator serviceValidator = new ServiceValidator();
         return serviceValidator.check(service);
    }
}
