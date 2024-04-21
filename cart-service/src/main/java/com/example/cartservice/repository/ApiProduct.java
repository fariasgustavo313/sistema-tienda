package com.example.cartservice.repository;

import com.example.cartservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "apiproduct", url = "http://localhost:8083/products")
public interface ApiProduct {

    @GetMapping("/{id_product}")
    public Product getProductById(@PathVariable Long id_product);
}
