package com.onik.service;

import com.onik.entity.Product;
import com.onik.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by onik on 1/7/17.
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Collection<Product> findAll() {
        Collection<Product> productCollection = productRepository.findAll();
        Collection<Product> responseCollection = new ArrayList<>();

        for(Product p : productCollection) {
            if(!p.isDeleted()) {
                responseCollection.add(p);
            }
        }

        return responseCollection;
    }

    public Product findOne(String PRODUCT_NUMBER) {
        return productRepository.findOne(PRODUCT_NUMBER);
    }

    public Product save(Product product) {
        if(product == null ||
                product.getPRICE() <= 0 ||
                product.getPRODUCT_NAME() == null ||
                product.getPRODUCT_NAME().length() == 0 ||
                product.getPRODUCT_NUMBER() == null ||
                product.getPRODUCT_NAME().length() == 0) {
            return product;
        }

        try {
            productRepository.save(product);

            return product;
        } catch (Exception ex) {
            product = new Product();
            return product;
        }
    }

    public boolean delete(String PRODUCT_NUMBER) {
        try {
            Product product = productRepository.findOne(PRODUCT_NUMBER);

            if(product == null) {
                return false;
            }
            else {
                product.setDeleted(true);
                productRepository.save(product);
            }

            return true;

        } catch (Exception ex) {
            return false;
        }
    }
}
