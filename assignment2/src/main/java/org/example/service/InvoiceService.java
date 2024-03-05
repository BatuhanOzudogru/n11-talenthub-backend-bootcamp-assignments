package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Invoice;
import org.example.repository.InvoiceRepository;

import java.util.List;
import java.util.stream.Collectors;


public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoice(Customer customer, Invoice invoice) {
        customer.addInvoice(invoice);
        invoice.setCustomer(customer);
        invoiceRepository.save(invoice);
    }

    public double getTotalInvoiceAmountForCustomer(Customer customer) {
        return customer.getInvoices().stream()
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoicesOver1500() {
        return getAllInvoices().stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .collect(Collectors.toList());
    }

    public double getAverageInvoiceAmountOver1500() {
        List<Invoice> invoicesOver1500 = getInvoicesOver1500();
        if (invoicesOver1500.isEmpty()) {
            return 0;
        }
        return invoicesOver1500.stream()
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

}
