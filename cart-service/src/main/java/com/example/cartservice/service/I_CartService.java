package com.example.cartservice.service;

import com.example.cartservice.model.Cart;

import java.util.List;

public interface I_CartService {

    public void addCart(Cart cart);
    public void deleteCart(Long id_cart);
    public void editCart(Long id_cart, Cart cart);
    public List<Cart> getAllCarts();
    public Cart getCart(Long id_cart);
}
