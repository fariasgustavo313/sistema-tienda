package com.example.saleservice.controller;

import com.example.saleservice.dto.SaleDTO;
import com.example.saleservice.model.Cart;
import com.example.saleservice.model.Product;
import com.example.saleservice.model.Sale;
import com.example.saleservice.repository.ApiCart;
import com.example.saleservice.service.I_SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ApiCart apiCart;
    @Autowired
    private I_SaleService interSale;

    @PostMapping
    public String addSale(@RequestBody Sale sale) {
        interSale.addSale(sale);
        return "Sale added succesfully";
    }

    @DeleteMapping("/{id_sale}")
    public String deleteSale(@PathVariable Long id_sale) {
        interSale.deleteSale(id_sale);
        return "Sale eliminated succesfully";
    }

    @PutMapping("/{id_sale}")
    public String editSale(@PathVariable Long id_sale,
                           @RequestBody Sale sale) {
        interSale.editSale(id_sale, sale);
        return "Sale edited succesfully";
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return interSale.getAllSales();
    }

    @GetMapping("/{id_sale}")
    public SaleDTO getSale(@PathVariable Long id_sale) {
        Sale sale = interSale.getSale(id_sale);
        Cart cart = apiCart.getCartById(sale.getId_cart());
        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setId_sale(id_sale);
        saleDTO.setDate(LocalDate.now());
        saleDTO.setTotal(cart.getTotal());
        saleDTO.setProduct_list(cart.getId_product_list());
        return saleDTO;
    }
}
