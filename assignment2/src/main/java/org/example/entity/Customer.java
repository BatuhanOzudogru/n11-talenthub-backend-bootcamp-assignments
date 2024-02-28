package org.example.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private final LocalDate registrationDate;
    private final String sector;
    private final List<Invoice> invoices;

    public Customer(String name, LocalDate registrationDate, String sector) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.sector = sector;
        this.invoices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getSector() {
        return sector;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }
}
