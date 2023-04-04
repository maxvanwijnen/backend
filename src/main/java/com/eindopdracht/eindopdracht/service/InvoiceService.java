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

    private final InvoiceRepository repos;

    public InvoiceService(InvoiceRepository repos) {
        this.repos = repos;
    }

    public Long createInvoice(InvoiceDto idto) {
        Invoice i = new Invoice();

        i.setTotalBeforeTax(idto.totalBeforeTax);
        i.setTax(idto.tax);
        i.setTotalAfterTax(idto.totalAfterTax);
        i.setOrderLines(idto.orderLines);
        i.setPayed(false);

        repos.save(i);

        return i.getId();
    }

    public InvoiceDto getInvoice(Long id) {
        Invoice i = repos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));

        InvoiceDto idto = new InvoiceDto();

        idto.id = i.getId();
        idto.tax = i.getTax();
        idto.totalAfterTax = i.getTotalAfterTax();
        idto.totalBeforeTax = i.getTotalBeforeTax();
        idto.orderLines = (ArrayList<String>) i.getOrderLines();
        idto.isPayed = i.isPayed();

        return idto;
    }

    public List getInvoices() {
        Iterable<Invoice> invoices = repos.findAll();

        List<InvoiceDto> invoiceDtos = new ArrayList<>();
        for (Invoice i : invoices) {
            InvoiceDto idto = new InvoiceDto();
            idto.id = i.getId();
            idto.tax = i.getTax();

            idto.totalBeforeTax = i.getTotalBeforeTax();
            idto.totalAfterTax = i.getTotalAfterTax();
            idto.isPayed = i.isPayed();

            invoiceDtos.add(idto);
        }
        return invoiceDtos;
    }


    public List getInvoicesBySearchParams(Integer customerId) {
        Iterable<Invoice> invoices = repos.findByCustomerId(customerId);

        List<InvoiceDto> invoicesDtos = new ArrayList<>();
        for (Invoice i : invoices) {
            InvoiceDto idto = new InvoiceDto();
            idto.id = i.getId();
            idto.tax = i.getTax();

            idto.totalBeforeTax = i.getTotalBeforeTax();
            idto.totalAfterTax = i.getTotalAfterTax();
            invoicesDtos.add(idto);
        }
        return invoicesDtos;
    }
}
