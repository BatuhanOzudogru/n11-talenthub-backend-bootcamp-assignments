package org.example.repository;

import org.example.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private final List<Invoice> invoices;

    public InvoiceRepository() {
        this.invoices = new ArrayList<>();
    }

    public void save(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> findAll() {
        return invoices;
    }
}
