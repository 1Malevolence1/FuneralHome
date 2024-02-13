package org.example.domain.service;

public class Service {
    private String nameService;
    private String descriptionService;
    private String priseService;

    public Service(String nameService, String descriptionService, String priseService) {
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

    public String getPriseService() {
        return priseService;
    }

    public void setPriseService(String priseService) {
        this.priseService = priseService;
    }
}
