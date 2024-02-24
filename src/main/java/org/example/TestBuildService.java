package org.example;

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
}
