package com.example.cartservice.service;

import com.example.cartservice.dto.CartDTO;
import com.example.cartservice.model.Cart;
import com.example.cartservice.model.Product;
import com.example.cartservice.repository.ApiProduct;
import com.example.cartservice.repository.CartRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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
        Cart ct = cartRepository.findById(id_cart).orElse(null);

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
    @CircuitBreaker(name = "product-service", fallbackMethod = "fallbackGetProducts")
    @Retry(name = "product-service")
    public CartDTO getCart(Long id_cart) {

        List<Product> productList = new ArrayList<>();
        Cart cart = cartRepository.findById(id_cart).orElse(null);

        for (Long id_product : cart.getId_product_list()) {
            Product product = apiProduct.getProductById(id_product);
            productList.add(product);
        }
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId_cart(id_cart);
        cartDTO.setTotal(cart.getTotal());
        cartDTO.setProduct_list(productList);

        createExcepcion();
        return cartDTO;
    }

    public CartDTO fallbackGetProducts(Throwable throwable) {
        return new CartDTO(9999999L, 9999999, null);
    }

    public void createExcepcion() {
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }
}
