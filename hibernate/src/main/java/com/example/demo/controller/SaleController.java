package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SaleDTO;
import com.example.demo.service.SaleService;

@RestController
@RequestMapping("sale")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@RequestMapping("createOrUpdate")
	SaleDTO createOrUpdate(@RequestBody SaleDTO saledto) {

		SaleDTO dto = saleService.createOrUpdate(saledto);
		return dto;
	}

	@RequestMapping("getById")
	SaleDTO getById(@RequestHeader(value = "studentId", defaultValue = "") String saleId) {
		SaleDTO dto = saleService.getById(saleId);
		return dto;
	}

	@RequestMapping("getAll")
	List<SaleDTO> getAll() {
		List<SaleDTO> studentDTOList = saleService.getAll();
		return studentDTOList;
	}

}