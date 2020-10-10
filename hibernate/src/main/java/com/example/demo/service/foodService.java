package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.foodDTO;

public interface foodService {

	foodDTO createOrUpdate(foodDTO foodDTO);

	foodDTO getById(String saletId);

	List<foodDTO> getAll();

}
