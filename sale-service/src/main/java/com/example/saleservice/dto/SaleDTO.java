package com.example.saleservice.dto;

import com.example.saleservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {

    private Long id_sale;
    private LocalDate date;
    private double total;
    private List<Long> product_list;
}
