package com.eindopdracht.eindopdracht.service;

import com.eindopdracht.eindopdracht.dto.CustomerDto;
import com.eindopdracht.eindopdracht.dto.InvoiceDto;
import com.eindopdracht.eindopdracht.exception.ResourceNotFoundException;
import com.eindopdracht.eindopdracht.model.Customer;
import com.eindopdracht.eindopdracht.model.Invoice;
import com.eindopdracht.eindopdracht.repository.CustomerRepository;
import com.eindopdracht.eindopdracht.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepos;
    private final CustomerRepository customerRepos;

    public InvoiceService(InvoiceRepository invoiceRepository, CustomerRepository customerRepository) {

        this.invoiceRepos = invoiceRepository;
        this.customerRepos = customerRepository;

    }

    public Long createInvoice(InvoiceDto idto) {
        Invoice i = new Invoice();
        //nogdoen
        //checken of er een id is
        //checken of de customer wel bestaat
        Customer customer = customerRepos.findById(idto.customerId).get();

        i.setTotalBeforeTax(idto.totalBeforeTax);
        i.setTax(idto.tax);
        i.setTotalAfterTax(idto.totalAfterTax);
        i.setOrderLines(idto.orderLines);
        i.setPayed(false);
        i.setCustomer(customer);

        invoiceRepos.save(i);

        return i.getId();
    }

    public InvoiceDto getInvoice(Long id) {
        Invoice i = invoiceRepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));

        InvoiceDto idto = new InvoiceDto();

        idto.id = i.getId();
        idto.tax = i.getTax();
        idto.totalAfterTax = i.getTotalAfterTax();
        idto.totalBeforeTax = i.getTotalBeforeTax();
        idto.orderLines = (ArrayList<String>) i.getOrderLines();
        idto.isPayed = i.isPayed();
        if (i.getCustomer() != null){
            idto.customerId = i.getCustomer().getId();
        }

        return idto;
    }

    public List getInvoices() {
        Iterable<Invoice> invoices = invoiceRepos.findAll();

        List<InvoiceDto> invoiceDtos = new ArrayList<>();
        for (Invoice i : invoices) {
            InvoiceDto idto = new InvoiceDto();
            idto.id = i.getId();
            idto.tax = i.getTax();

            idto.totalBeforeTax = i.getTotalBeforeTax();
            idto.totalAfterTax = i.getTotalAfterTax();
            idto.isPayed = i.isPayed();
            if (i.getCustomer() != null){
                idto.customerId = i.getCustomer().getId();
            }


            invoiceDtos.add(idto);
        }
        return invoiceDtos;
    }


    public List getInvoicesBySearchParams(Long customerId) {
        Iterable<Invoice> invoices = invoiceRepos.findByCustomerId(customerId);

        List<InvoiceDto> invoicesDtos = new ArrayList<>();


        for (Invoice i : invoices) {
            InvoiceDto idto = new InvoiceDto();

            idto.tax = i.getTax();
            idto.totalBeforeTax = i.getTotalBeforeTax();
            idto.totalAfterTax = i.getTotalAfterTax();
            idto.id = i.getId();
            idto.isPayed = i.isPayed();
            invoicesDtos.add(idto);
            if (i.getCustomer() != null){
                idto.customerId = i.getCustomer().getId();
            }
        }
        return invoicesDtos;
    }
}
