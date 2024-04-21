package com.example.productservice.controller;

import com.example.productservice.model.Product;
import com.example.productservice.service.I_ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private I_ProductService interProduct;
    @Value("${server.port}")
    private int serverPort;

    @PostMapping
    public String addProduct(@RequestBody Product product) {
        interProduct.addProduct(product);
        System.out.println("*********** ESTE ES EL PUERTO " + serverPort + " *************************");
        return "product successfully added";
    }

    @DeleteMapping("/{id_product}")
    public String deleteProduct(@PathVariable Long id_product) {
        interProduct.deleteProduct(id_product);
        return "product successfully removed";
    }

    @PutMapping("/{id_product}")
    public String editProduct(@PathVariable Long id_product,
                              @RequestBody Product product) {
        interProduct.editProduct(id_product, product);
        return "successfully edited product";
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return interProduct.getAllProducts();
    }

    @GetMapping("/{id_product}")
    public Product getProduct(@PathVariable Long id_product) {
        return interProduct.getProduct(id_product);
    }

    @GetMapping("/get/{name}")
    public Product getProductByName(@PathVariable String name) {
        return interProduct.getProductByName(name);
    }

    @GetMapping("/prueba")
    public String probarLoadBalancer() {
        return "Este es el puerto " + serverPort;
    }
}
