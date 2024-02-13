package org.example.domen.contract;

import org.example.domen.person.Customers;
import org.example.domen.person.Staff;
import org.example.domen.person.TheDeadMen;
import org.example.domen.service.Service;
import sun.util.resources.LocaleData;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Contract {
    private Customers customers;
    private Staff staff;
    private TheDeadMen theDeadMen;
    private List<Service> services;

    private LocaleData dateConclusionContract;
    private Double totalAmountForServices;


    public Contract() {
    }


    public void addService(Service service){
        if(services == null){
            services = new ArrayList<>();
        }
        services.add(service);
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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

    public LocaleData getDateConclusionContract() {
        return dateConclusionContract;
    }

    public void setDateConclusionContract(LocaleData dateConclusionContract) {
        this.dateConclusionContract = dateConclusionContract;
    }

    public Double getTotalAmountForServices() {
        return totalAmountForServices;
    }

    public void setTotalAmountForServices(Double totalAmountForServices) {
        this.totalAmountForServices = totalAmountForServices;
    }
}
