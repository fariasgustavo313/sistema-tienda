package com.example.productservice.service;

import com.example.productservice.ProductServiceApplication;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements I_ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id_product) {
        productRepository.deleteById(id_product);
    }

    @Override
    public void editProduct(Long id_product, Product product) {
        Product prod = this.getProduct(id_product);
        prod.setName(product.getName());
        prod.setBrand(product.getBrand());
        prod.setPrice(product.getPrice());

        productRepository.save(prod);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id_product) {
        return productRepository.findById(id_product).orElse(null);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.getProductByName(name);
    }
}
