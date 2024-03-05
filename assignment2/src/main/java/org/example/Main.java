package org.example;
<<<<<<< HEAD
=======


>>>>>>> eb145f6bb2ade3a9dbb85af91ca5195ac647d3b9
import org.example.entity.Customer;
import org.example.entity.Invoice;
import org.example.repository.CustomerRepository;
import org.example.repository.InvoiceRepository;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();
        InvoiceRepository invoiceRepository = new InvoiceRepository();

        InvoiceService invoiceService = new InvoiceService(invoiceRepository);
        CustomerService customerService = new CustomerService(customerRepository, invoiceService);

        customerService.createCustomer("Alice", LocalDate.of(2024, 2, 20), "IT");
        customerService.createCustomer("Bob", LocalDate.of(2023, 6, 15), "Finance");
        customerService.createCustomer("Charlie", LocalDate.of(2022, 6, 1), "Sales");
        customerService.createCustomer("David", LocalDate.of(2021, 6, 1), "Marketing");

        invoiceService.addInvoice(customerService.getAllCustomers().get(0), new Invoice("INV-1", 100, LocalDate.of(2024, 3, 20)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(0), new Invoice("INV-10", 1000, LocalDate.of(2024, 3, 21)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(0), new Invoice("INV-2", 200, LocalDate.of(2024, 4, 22)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(0), new Invoice("INV-20", 2000, LocalDate.of(2024, 4, 23)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(1), new Invoice("INV-3", 300, LocalDate.of(2024, 5, 24)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(1), new Invoice("INV-30", 3000, LocalDate.of(2024, 5, 25)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(1), new Invoice("INV-4", 400, LocalDate.of(2024, 6, 26)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(1), new Invoice("INV-40", 4000, LocalDate.of(2024, 6, 27)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(2), new Invoice("INV-5", 500, LocalDate.of(2024, 7, 28)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(2), new Invoice("INV-50", 5000, LocalDate.of(2024, 7, 29)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(2), new Invoice("INV-6", 600, LocalDate.of(2024, 8, 1)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(2), new Invoice("INV-60", 6000, LocalDate.of(2024, 8, 2)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(3), new Invoice("INV-7", 700, LocalDate.of(2024, 9, 3)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(3), new Invoice("INV-70", 7000, LocalDate.of(2024, 9, 4)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(3), new Invoice("INV-8", 800, LocalDate.of(2024, 10, 5)));
        invoiceService.addInvoice(customerService.getAllCustomers().get(3), new Invoice("INV-80", 8000, LocalDate.of(2024, 10, 6)));

        System.out.println("All Customers:");
        customerService.getAllCustomers().forEach(customer -> System.out.println(customer.getName()));

        System.out.println("Customers with 'C' in their names:");
        customerService.getCustomersWithC().forEach(customer -> System.out.println(customer.getName()));

        double totalInvoiceAmountInJune = customerService.getTotalInvoiceAmountOfCustomersRegisteredInJune();
        System.out.println("Total invoice amount for customers registered in June: " + totalInvoiceAmountInJune);

        System.out.println("All invoices:");
        invoiceService.getAllInvoices().forEach(invoice -> System.out.println("Number: " + invoice.getNumber() + ", Amount: " + invoice.getAmount()));

        System.out.println("Invoices over 1500:");
        invoiceService.getInvoicesOver1500().forEach(invoice -> System.out.println("Number: " + invoice.getNumber() + ", Amount: " + invoice.getAmount()));

        double averageOver1500 = invoiceService.getAverageInvoiceAmountOver1500();
        System.out.println("Average of invoices over 1500: " + averageOver1500);

        System.out.println("Customers with invoices under 500:");
        customerService.getCustomersWithInvoicesUnder500().forEach(customer -> System.out.println(customer.getName()));

        System.out.println("Customers with invoices under 750:");
        customerService.getCustomersWithInvoicesUnder750().forEach(customer -> System.out.println("Customer: " + customer.getName() + ", Sector: " + customer.getSector()));
    }
}