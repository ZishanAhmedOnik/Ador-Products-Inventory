package com.onik.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.entity.Outlet;
import com.onik.entity.Product;
import com.onik.entity.Stock;
import com.onik.entity.StockDTO;
import com.onik.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	private ProductService productService;
	@Autowired
	private OutletService outletService;
	@Autowired
	private StockRepository stockRepository;

	public Collection<Stock> getStockByProduct(String productNumber) {
		Product product = productService.findOne(productNumber);

		return stockRepository.findByProduct(product);
	}

	public Collection<Stock> getStockByOutlet(Long outletId) {
		Outlet outlet = outletService.findOne(outletId);

		return stockRepository.findByOutlet(outlet);
	}

	public Stock addSales(StockDTO stockDTO) {
		Stock stock = null;

		if ((stockDTO.getOUTLET_ID() != 0 && stockDTO.getOUTLET_ID() > 0)
				&& (stockDTO.getPRODUCT_NUMBER() != null && stockDTO.getPRODUCT_NUMBER().length() != 0)) {
			Product product = productService.findOne(stockDTO.getPRODUCT_NUMBER());
			Outlet outlet = outletService.findOne(stockDTO.getOUTLET_ID());

			stock = stockRepository.findByOutletAndProduct(outlet, product);

			if (stock != null) {
				stock.setQuantity(stock.getQuantity() - stockDTO.getQuantity());
			} else {
				stock = new Stock();
				stock.setOutlet(outlet);
				stock.setProduct(product);
				stock.setQuantity(stockDTO.getQuantity());
			}

			stockRepository.save(stock);
		}

		return stock;
	}

	public Stock addSupply(StockDTO stockDTO) {
		Stock stock = null;

		if ((stockDTO.getOUTLET_ID() != 0 && stockDTO.getOUTLET_ID() > 0)
				&& (stockDTO.getPRODUCT_NUMBER() != null && stockDTO.getPRODUCT_NUMBER().length() != 0)) {
			Product product = productService.findOne(stockDTO.getPRODUCT_NUMBER());
			Outlet outlet = outletService.findOne(stockDTO.getOUTLET_ID());

			stock = stockRepository.findByOutletAndProduct(outlet, product);

			if (stock != null) {
				stock.setQuantity(stock.getQuantity() + stockDTO.getQuantity());
			} else {
				stock = new Stock();
				stock.setOutlet(outlet);
				stock.setProduct(product);
				stock.setQuantity(stockDTO.getQuantity());
			}

			stockRepository.save(stock);
		}
		
		return stock;
	}

	public Stock findByOutletAndProduct(StockDTO stockDTO) {
		Product product = productService.findOne(stockDTO.getPRODUCT_NUMBER());
		Outlet outlet = outletService.findOne(stockDTO.getOUTLET_ID());
		
		Stock stock = null;
		
		if ((stockDTO.getOUTLET_ID() != 0 && stockDTO.getOUTLET_ID() > 0)
				&& (stockDTO.getPRODUCT_NUMBER() != null && stockDTO.getPRODUCT_NUMBER().length() != 0)) {
			stock = stockRepository.findByOutletAndProduct(outlet, product);
			
			if(stock == null) {
				stock = new Stock();
			}
		}
		
		return stock;
	}
}
