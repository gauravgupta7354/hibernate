package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.SaleDTO;

public interface SaleService {

	SaleDTO createOrUpdate(SaleDTO saleDTO);

	SaleDTO getById(String studentId);

	List<SaleDTO> getAll();

}
