package com.onik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onik.entity.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
