package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.companyDTO;

public interface CompanyService {

	companyDTO createOrUpdate(companyDTO companyDTO);

	companyDTO getById(String saletId);

	List<companyDTO> getAll();

}
