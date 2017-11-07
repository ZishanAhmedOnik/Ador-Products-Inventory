package com.onik.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.entity.Invoice;
import com.onik.entity.InvoiceDTO;
import com.onik.entity.InvoiceDetails;
import com.onik.entity.InvoiceEntry;
import com.onik.entity.InvoicedProductEntry;
import com.onik.entity.Outlet;
import com.onik.entity.Product;
import com.onik.repository.InvoiceRepository;
import com.onik.repository.OutletRepository;
import com.onik.repository.ProductRepository;

@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	OutletRepository outletRepository;
	@Autowired
	ProductRepository productRepository;
	
	public Collection<InvoiceDTO> findAll() {
		Collection<Invoice> invoiceCollection = invoiceRepository.findAll();
		Collection<InvoiceDTO> invoiceDTOCollection = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyy");
		
		invoiceCollection.forEach(invoice -> {
			InvoiceDTO invoiceDTO = new InvoiceDTO();
			
			invoiceDTO.setID(invoice.getID());
			invoiceDTO.setInvoiceDate(sdf.format(invoice.getDate()));
			invoiceDTO.setOutletName(invoice.getOutlet().getOUTLET_NAME());
			
			invoiceDTOCollection.add(invoiceDTO);
		});
		
		return invoiceDTOCollection;
	}
	
	public Invoice findOne(Long id) {
		return invoiceRepository.findOne(id);
	}
	
	public Invoice getLastInvoice() {
		ArrayList<Invoice> invoiceList = (ArrayList<Invoice>) invoiceRepository.findAll();
		return invoiceList.get(invoiceList.size() - 1);
	}
	
	public boolean save(InvoiceEntry entry) {
		Outlet outlet = outletRepository.getOne(entry.getOutletID());
		
		Invoice invoice = new Invoice();
		invoice.setDate(entry.getInvoiceDate());
		invoice.setOutlet(outlet);
		
		Collection<InvoiceDetails> invoiceDetailsCollection = new ArrayList<>();
		
		invoice = invoiceRepository.save(invoice);
		
		final Long invoiceId = invoice.getID();
		
		entry.getInvoicedProductEntries().stream().forEach(details -> {
			Product product = productRepository.getOne(details.getProductID());
			
			InvoiceDetails invoiceDetails = new InvoiceDetails();
			invoiceDetails.setQuantity(details.getQuantity());
			invoiceDetails.setProduct(product);
			invoiceDetails.setINVOICE_ID(invoiceId);
			
			invoiceDetailsCollection.add(invoiceDetails);
		});
		
		invoice.setInvoiceDetailsCollection(invoiceDetailsCollection);
		
		try {
			invoiceRepository.save(invoice);
			
			return true;
		} catch (Exception e) {
			System.out.println(e);
			
			return false;
		}
	}
}
