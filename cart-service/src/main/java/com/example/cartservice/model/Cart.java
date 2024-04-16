package com.example.cartservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cart;
    private double total;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "cart_product_list")
    private List<Long> id_product_list;
}
