package org.example.domen.service;

import org.example.domen.contract.Contract;

import java.util.List;

public class ServiceInTheContract {
    private Service service;
    private Contract contract;

    private Integer countAllService;

    public ServiceInTheContract(Service service, Contract contract) {
        this.service = service;
        this.contract = contract;
    }

    // @TODO
    private Integer lengthAllService(List<Service> services){
        return services.size();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getCountAllService() {
        return countAllService;
    }

    public void setCountAllService(Integer countAllService) {
        this.countAllService = countAllService;
    }
}
