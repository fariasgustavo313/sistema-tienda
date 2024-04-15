package com.example.cartservice.repository;

import com.example.cartservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "apiproduct", url = "http://localhost:8081/products")
public interface ApiProduct {

    @GetMapping()
    public List<Product> getAllProducts();
}
