package com.onik.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onik.entity.Invoice;
import com.onik.entity.InvoiceDTO;
import com.onik.entity.InvoiceEntry;
import com.onik.entity.InvoicedProductEntry;
import com.onik.service.InvoiceService;

@RestController
@CrossOrigin
@RequestMapping("/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping("/")
	public Collection<InvoiceDTO> getAll() {
		return invoiceService.findAll();
	}
	
	@GetMapping("/{INVOICE_ID}")
	public Invoice getByID(@PathVariable("INVOICE_ID") Long id) {
		return invoiceService.findOne(id);
	}
	
	@GetMapping("/getLastInvoiceID")
	public Long getLastInvoiceID() {
		return invoiceService.getLastInvoice().getID();
	}
	
	@PostMapping("/save")
	public boolean SaveInvoice(@RequestBody InvoiceEntry entry) {
		return invoiceService.save(entry);
	}
}
