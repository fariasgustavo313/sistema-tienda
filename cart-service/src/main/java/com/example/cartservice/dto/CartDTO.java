package com.example.cartservice.dto;

import com.example.cartservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Long id_cart;
    private double total;
    private List<Product> product_list;
}
