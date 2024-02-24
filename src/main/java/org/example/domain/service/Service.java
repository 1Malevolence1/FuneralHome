package org.example.domain.service;

public class Service {
    private String nameService;
    private String descriptionService;
    private Integer priseService;

    public Service(String nameService, String descriptionService, Integer priseService) {
        this.nameService = nameService;
        this.descriptionService = descriptionService;
        this.priseService = priseService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getDescriptionService() {
        return descriptionService;
    }

    public void setDescriptionService(String descriptionService) {
        this.descriptionService = descriptionService;
    }

    public Integer getPriseService() {
        return priseService;
    }

    public void setPriseService(Integer priseService) {
        this.priseService = priseService;
    }
}
