package com.realestate.service.impl;

import com.realestate.entities.ClientReg;
import com.realestate.entities.Sale;
import com.realestate.payload.SaleDto;
import com.realestate.repositories.ClientRegRepository;
import com.realestate.repositories.SaleRepository;
import com.realestate.service.SaleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class SaleServiceImpl implements SaleService {

    private SaleRepository saleRepository;
    private ClientRegRepository clientRegRepository;

    public SaleServiceImpl(SaleRepository saleRepository, ClientRegRepository clientRegRepository) {
        this.saleRepository = saleRepository;
        this.clientRegRepository = clientRegRepository;
    }

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        ClientReg clientReg = clientRegRepository.findById(saleDto.getClientId()).orElseThrow(
                ()-> new EntityNotFoundException("clientId Not Found")
        );
        Sale sale = new Sale();
        sale.setClientId(clientReg.getClientId());
        sale.setAgentId(saleDto.getAgentId());
        sale.setPropertyId(saleDto.getPropertyId());
        sale.setSaleDate(saleDto.getSaleDate());
        Sale savedSale = saleRepository.save(sale);

        SaleDto dto = new SaleDto();
        dto.setClientId(savedSale.getClientId());
        dto.setAgentId(savedSale.getAgentId());
        dto.setPropertyId(savedSale.getPropertyId());
        dto.setSaleDate(savedSale.getSaleDate());
        return dto;
    }
}
