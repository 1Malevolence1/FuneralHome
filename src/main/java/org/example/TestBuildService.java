package org.example;

import basedate.dataaccess.DataManager;
import org.example.answer.AnswerService;
import org.example.domain.service.Service;

public class TestBuildService {
    public static Service service(){
        Service service = new Service(
                "Выкопать ямку для могилы",
                "Подготовим ямку",
                10_000
        );

        return service;
    }

    public static void main(String[] args) {
        AnswerService answerService = new AnswerService();
        answerService.setService(TestBuildService.service());
        DataManager dataManager = new DataManager();
      /*  dataManager.loaderService();*/
    }
}
