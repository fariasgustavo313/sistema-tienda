package com.example.saleservice.service;

import com.example.saleservice.model.Sale;

import java.util.List;

public interface I_SaleService {

    public void addSale(Sale sale);
    public void deleteSale(Long id_sale);
    public void editSale(Long id_sale, Sale sale);
    public List<Sale> getAllSales();
    public Sale getSale(Long id_sale);
}
