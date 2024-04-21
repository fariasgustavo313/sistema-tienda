package com.example.saleservice.repository;

import com.example.saleservice.model.Cart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "apicart", url = "http://localhost:8086/carts")
public interface ApiCart {

    @GetMapping("/{id_cart}")
    public Cart getCartById(@PathVariable Long id_cart);
}
