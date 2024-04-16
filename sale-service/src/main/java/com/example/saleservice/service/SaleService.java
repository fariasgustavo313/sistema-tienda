package com.example.saleservice.service;

import com.example.saleservice.model.Cart;
import com.example.saleservice.model.Sale;
import com.example.saleservice.repository.ApiCart;
import com.example.saleservice.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements I_SaleService {

    @Autowired
    private ApiCart apiCart;
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public void addSale(Sale sale) {
        sale.setDate(LocalDate.now());
        saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Long id_sale) {
        saleRepository.deleteById(id_sale);
    }

    @Override
    public void editSale(Long id_sale, Sale sale) {
        sale.setDate(LocalDate.now());
        saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSale(Long id_sale) {
        return saleRepository.findById(id_sale).orElse(null);
    }
}
