package com.example.cartservice.service;

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
    private CartRepository cartRepository;
    @Autowired
    private ApiProduct apiProduct;

    @Override
    public void addCart(Cart cart) {
        List<Product> productListApi = apiProduct.getAllProducts();
        List<Product> newCartList = new ArrayList<>();
        double subtotal = 0;

        for (Product productCart : cart.getProductList()) {
            for (Product productApi : productListApi) {
                if (productCart.equals(productApi)) {
                    newCartList.add(productCart);
                    subtotal += productCart.getPrice();
                }
            }
        }
        Cart ct = new Cart();
        ct.setProductList(newCartList);
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
        ct.setProductList(cart.getProductList());
        ct.setTotal(cart.getTotal());

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
