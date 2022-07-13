package com.abcode.dsmeta.services;

import com.abcode.dsmeta.entities.Sale;
import com.abcode.dsmeta.repositories.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {
    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        var min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        var max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return saleRepository.findSales(min, max, pageable);
    }
}
