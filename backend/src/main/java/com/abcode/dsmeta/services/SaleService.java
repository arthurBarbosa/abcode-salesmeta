package com.abcode.dsmeta.services;

import com.abcode.dsmeta.entities.Sale;
import com.abcode.dsmeta.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }
}
