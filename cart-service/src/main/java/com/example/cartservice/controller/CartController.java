package com.example.cartservice.controller;

import com.example.cartservice.model.Cart;
import com.example.cartservice.service.I_CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

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
    public Cart getCart(@PathVariable Long id_cart) {
        return interCart.getCart(id_cart);
    }
}
