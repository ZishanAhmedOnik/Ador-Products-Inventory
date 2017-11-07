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

import com.onik.entity.Stock;
import com.onik.entity.StockDTO;
import com.onik.service.StockService;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class StockController {
	@Autowired
	private StockService stockService;
	
	@GetMapping("/byproduct/{PRODUCT_NUMBER}")
	public Collection<Stock> getStockByProduct(@PathVariable("PRODUCT_NUMBER") String productNumber) {
		return stockService.getStockByProduct(productNumber);
	}
	
	@GetMapping("/byoutlet/{OUTLET_ID}")
	public Collection<Stock> getStockByOutlet(@PathVariable("OUTLET_ID") Long outletId) {
		return stockService.getStockByOutlet(outletId);
	}
	
	@PostMapping("/findByOutletAndProduct")
	public Stock findByOutletAndProduct(@RequestBody StockDTO stockDTO) {
		return stockService.findByOutletAndProduct(stockDTO);
	}
	
	@PostMapping("/addSales")
	public Stock addSales(@RequestBody StockDTO stockDTO) {
		return stockService.addSales(stockDTO);
	}
	
	@PostMapping("/addSupply")
	public Stock addSupply(@RequestBody StockDTO stockDTO) {
		return stockService.addSupply(stockDTO);
	}
}
