package org.example.validator.service;

import org.example.domain.service.Service;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorDataBase;
import org.example.exception.ValidatorService;

public class ServiceValidator {

    public Service check(Service service) throws ValidatorService {

        try {

            if (!service.getNameService().isEmpty() && !service.getDescriptionService().isEmpty() && service.getPriseService() != null) {
                return service;
            } else {
                throw new ValidatorService("Ошибка в данных услуги");
            }
        } catch (ValidatorService e) {
            System.out.println(e.getErrorMessage());
        }
        return null;
    }
}
