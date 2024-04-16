package com.example.cartservice.service;

import com.example.cartservice.dto.CartDTO;
import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Product;
import com.example.cartservice.repository.ApiProduct;
import com.example.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService implements I_CartService {

    @Autowired
    private ApiProduct apiProduct;
    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addCart(Cart cart) {
        List<Long> new_id_product_list = new ArrayList<>();
        double subtotal = 0;

        for (Long id_product : cart.getId_product_list()) {
            Product product = apiProduct.getProductById(id_product);
            new_id_product_list.add(product.getId_product());
            subtotal += product.getPrice();
        }
        Cart ct = new Cart();
        ct.setId_product_list(new_id_product_list);
        ct.setTotal(subtotal);

        cartRepository.save(ct);
    }

    @Override
    public void deleteCart(Long id_cart) {
        cartRepository.deleteById(id_cart);
    }

    @Override
    public void editCart(Long id_cart, Cart cart) {
        Cart ct = this.getCart(id_cart);

        List<Long> new_id_product_list = new ArrayList<>();
        double subtotal = 0;

        for (Long id_product : cart.getId_product_list()) {
            Product product = apiProduct.getProductById(id_product);
            new_id_product_list.add(product.getId_product());
            subtotal += product.getPrice();
        }

        ct.setId_product_list(new_id_product_list);
        ct.setTotal(subtotal);

        cartRepository.save(ct);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCart(Long id_cart) {
        return cartRepository.findById(id_cart).orElse(null);
    }
}
