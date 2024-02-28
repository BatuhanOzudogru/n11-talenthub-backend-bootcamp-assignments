package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Invoice;
import org.example.repository.CustomerRepository;

import java.time.Month;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.List;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private final InvoiceService invoiceService;

    public CustomerService(CustomerRepository customerRepository, InvoiceService invoiceService) {
        this.customerRepository = customerRepository;
        this.invoiceService = invoiceService;
    }

    public void createCustomer(String name, LocalDate registrationDate, String sector) { // Sektör bilgisi parametresi eklendi
        Customer customer = new Customer(name, registrationDate, sector); // Sektör bilgisi parametresi eklendi
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    public List<Customer> getCustomersWithC() {
        return getAllCustomers().stream()
                .filter(customer -> customer.getName().contains("C"))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersRegisteredInJune() {
        return customerRepository.findAllCustomers().stream()
                .filter(customer -> customer.getRegistrationDate().getMonth() == Month.JUNE)
                .collect(Collectors.toList());
    }

    public double getTotalInvoiceAmountOfCustomersRegisteredInJune() {
        List<Customer> customersRegisteredInJune = getCustomersRegisteredInJune();
        double totalInvoiceAmount = 0;
        for (Customer customer : customersRegisteredInJune) {
            totalInvoiceAmount += invoiceService.getTotalInvoiceAmountForCustomer(customer);
        }
        return totalInvoiceAmount;
    }

    public List<Invoice> getAllInvoices() {
        List<Invoice> allInvoices = new ArrayList<>();
        getAllCustomers().forEach(customer -> allInvoices.addAll(customer.getInvoices()));
        return allInvoices;
    }

    public List<Customer> getCustomersWithInvoicesUnder500() {
        return getAllCustomers().stream()
                .filter(customer -> customer.getInvoices().stream().anyMatch(invoice -> invoice.getAmount() < 500))
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersWithInvoicesUnder750() {
        return getAllCustomers().stream()
                .filter(customer -> customer.getInvoices().stream()
                        .anyMatch(invoice -> invoice.getAmount() < 750))
                .collect(Collectors.toList());
    }

}
