package com.example.productservice.service;

import com.example.productservice.model.Product;

import java.util.List;

public interface I_ProductService {

    public void addProduct(Product product);
    public void deleteProduct(Long id_product);
    public void editProduct(Long id_product, Product product);
    public List<Product> getAllProducts();
    public Product getProduct(Long id_product);
    public Product getProductByName(String name);
}
