package com.eindopdracht.eindopdracht.repository;

import com.eindopdracht.eindopdracht.model.Invoice;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    Iterable<Invoice> findByCustomerId(Integer customerId);
}
