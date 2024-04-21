package com.example.cartservice.controller;

import com.example.cartservice.dto.CartDTO;
import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Product;
import com.example.cartservice.repository.ApiProduct;
import com.example.cartservice.service.I_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Value("${server.port}")
    private int serverPort;
    @Autowired
    private ApiProduct apiProduct;
    @Autowired
    private I_CartService interCart;

    @PostMapping
    public String addCart(@RequestBody Cart cart) {
        interCart.addCart(cart);
        return "cart successfully added";
    }

    @DeleteMapping("/{id_cart}")
    public String deleteCart(@PathVariable Long id_cart) {
        interCart.deleteCart(id_cart);
        return "cart successfully deleted";
    }

    @PutMapping("/{id_cart}")
    public String editCart(@PathVariable Long id_cart,
                         @RequestBody Cart cart) {
        interCart.editCart(id_cart, cart);
        return "cart successfully edited";
    }

    @GetMapping
    public List<Cart> gatAllCarts() {
        return interCart.getAllCarts();
    }

    @GetMapping("/{id_cart}")
    public CartDTO getCart(@PathVariable Long id_cart) {
        return interCart.getCart(id_cart);
    }

    @GetMapping("/prueba")
    public String probarLoadBalancer() {
        return "Este es el puerto " + serverPort;
    }
}
