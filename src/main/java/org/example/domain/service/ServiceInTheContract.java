package org.example.domain.service;

import org.example.domain.contract.Contract;
import org.example.domain.service.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceInTheContract {

    private  int costService;
    private Contract contract;
    private List<Service> services;

    public int getCostService() {
        return costService;
    }

    public void setCostService(int costService) {
        this.costService = costService;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public void add(Service service){
        if(services == null){
            services = new ArrayList<>();
        }

        services.add(service);
    }

    public long getCountService(){
        return services.size();
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public  int getAllSumService(){
        int sum = 0;

        for (Service item: services
        ) {
            sum += item.getPriseService();
        }
        return sum;
    }
}
