package com.realestate.controller;

import com.realestate.payload.SaleDto;
import com.realestate.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    //http:localhost:8080/api/sales
    @PostMapping
    public ResponseEntity<SaleDto> saveSale(@RequestBody SaleDto saleDto) {
        SaleDto dto = saleService.saveSale(saleDto);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

}
