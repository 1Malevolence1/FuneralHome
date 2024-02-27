package org.example.domain.contract;

import org.example.domain.person.Customer;


import org.example.domain.person.TheDeadMen;
import org.example.domain.service.Service;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private long id;
    private Customer customer;

    private TheDeadMen theDeadMen;
    private List<Service> services;

    private LocalDate dateConclusionContract;
    private Double totalAmountForServices;

    private int allSumServices;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getAllSumServices() {
        return allSumServices;
    }

    public void setAllSumServices(int allSumServices) {
        this.allSumServices = allSumServices;
    }

    public Contract() {
    }




    public Customer getCustomers() {
        return customer;
    }

    public void setCustomers(Customer customers) {
        this.customer = customers;
    }

    public TheDeadMen getTheDeadMen() {
        return theDeadMen;
    }

    public void setTheDeadMen(TheDeadMen theDeadMen) {
        this.theDeadMen = theDeadMen;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public LocalDate getDateConclusionContract() {
        return dateConclusionContract;
    }

    public void setDateConclusionContract(LocalDate dateConclusionContract) {
        this.dateConclusionContract = dateConclusionContract;
    }

    public Double getTotalAmountForServices() {
        return totalAmountForServices;
    }

    public void setTotalAmountForServices(Double totalAmountForServices) {
        this.totalAmountForServices = totalAmountForServices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
