package org.example.entity;

import java.time.LocalDate;

public class Invoice {
    private final String number;
    private final double amount;
    private LocalDate createdAt;
    private Customer customer;

    public Invoice(String number, double amount, LocalDate createdAt) {
        this.number = number;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public String getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
