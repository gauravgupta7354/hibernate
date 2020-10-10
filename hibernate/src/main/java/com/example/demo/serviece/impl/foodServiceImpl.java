package com.example.demo.serviece.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.foodDao;
import com.example.demo.dto.foodDTO;
import com.example.demo.models.food;
import com.example.demo.service.foodService;

@Service
@Transactional(readOnly = true)
public class foodServiceImpl implements foodService {

	@Autowired
	private foodDao foodDao;

	@Override
	@Transactional(readOnly = false)
	public foodDTO createOrUpdate(foodDTO foodDTO) {
		food food = new food();
		try {
			String saleId = foodDTO.getSaleId();

			int size = foodDao.findAll().size();
			size = size + 1;

			if (saleId == null) {
				// Save New Row
				food.setSaleId("" + size);

				foodDTO.setSaleId("" + size);

			} else {

				food foodEntity = foodDao.findById(saleId);
				food.setSaleId(foodEntity.getSaleId());
				foodDTO.setSaleId(food.getSaleId());
			}
			food.setName(foodDTO.getName());
			food.setCompanyId(foodDTO.getCompanyId());

			foodDao.saveOrUpdate(food);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return foodDTO;
	}

	@Override
	public foodDTO getById(String saleId) {
		foodDTO dto = new foodDTO();

		try {
			food food = foodDao.findById(saleId);

			dto.setSaleId(food.getSaleId());
			dto.setName(food.getName());
			dto.setCompanyId(food.getCompanyId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<foodDTO> getAll() {

		List<foodDTO> dtoList = new ArrayList<>();

		try {

			List<food> foodList = foodDao.findAll();

			for (food food : foodList) {
				foodDTO dto = new foodDTO();
				dto.setSaleId(food.getSaleId());
				dto.setName(food.getName());
				dto.setCompanyId(food.getCompanyId());
				dtoList.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
