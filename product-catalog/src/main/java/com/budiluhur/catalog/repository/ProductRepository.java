package com.budiluhur.catalog.repository;

import com.budiluhur.catalog.exception.ProductNotFoundException;
import com.budiluhur.catalog.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product("PRD-01", "Keyboard Mechanical", 450000.0));
        productList.add(new Product("PRD-02", "Mouse Wireless", 150000.0));
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product findById(String id) throws ProductNotFoundException {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(
                        "Produk dengan ID '" + id + "' tidak ditemukan!"));
    }

    public void save(Product product) {
        productList.add(product);
    }

    public Product updateProduct(String id, Product updatedProduct) throws ProductNotFoundException {
        Product existingProduct = findById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        return existingProduct;
    }

    public boolean deleteById(String id) throws ProductNotFoundException {
        Product existingProduct = findById(id);
        return productList.remove(existingProduct);
    }

    // Mini Challenge: pencarian berdasarkan nama
    public List<Product> searchByName(String keyword) {
        return productList.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
}
