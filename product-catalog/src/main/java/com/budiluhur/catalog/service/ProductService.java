package com.budiluhur.catalog.service;

import com.budiluhur.catalog.exception.ProductNotFoundException;
import com.budiluhur.catalog.model.Product;
import com.budiluhur.catalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) throws ProductNotFoundException {
        return productRepository.findById(id);
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) throws ProductNotFoundException {
        return productRepository.updateProduct(id, product);
    }

    public boolean deleteProduct(String id) throws ProductNotFoundException {
        return productRepository.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepository.searchByName(keyword);
    }
}
