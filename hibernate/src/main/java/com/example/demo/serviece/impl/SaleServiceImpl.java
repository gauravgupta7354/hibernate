package com.example.demo.serviece.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SaleDao;
import com.example.demo.dto.SaleDTO;
import com.example.demo.models.sale;
import com.example.demo.service.SaleService;

@Service
@Transactional(readOnly = true)
public class SaleServiceImpl implements SaleService {

	@Autowired
	private SaleDao saleDao;

	@Override
	@Transactional(readOnly = false)
	public SaleDTO createOrUpdate(SaleDTO saleDTO) {
		sale sale = new sale();
		try {
			String saleId = saleDTO.getSaleId();

			int size = saleDao.findAll().size();
			size = size + 1;

			if (saleId == null) {
				// Save New Row
				sale.setSaleId("" + size);

				saleDTO.setSaleId("" + size);

			} else {

				sale studentEntity = saleDao.findById(saleId);
				sale.setSaleId(studentEntity.getSaleId());
				saleDTO.setSaleId(sale.getSaleId());
			}
			sale.setQuantity(saleDTO.getQuantity());
			sale.setRate(saleDTO.getRate());

			saleDao.saveOrUpdate(sale);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return saleDTO;
	}

	@Override
	public SaleDTO getById(String saleId) {
		SaleDTO dto = new SaleDTO();

		try {
			sale sale = saleDao.findById(saleId);

			dto.setSaleId(sale.getSaleId());
			dto.setQuantity(sale.getQuantity());
			dto.setRate(sale.getRate());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<SaleDTO> getAll() {

		List<SaleDTO> dtoList = new ArrayList<>();

		try {

			List<sale> studentList = saleDao.findAll();

			for (sale sale : studentList) {
				SaleDTO dto = new SaleDTO();
				dto.setSaleId(sale.getSaleId());
				dto.setQuantity(sale.getQuantity());
				dto.setRate(sale.getRate());
				dtoList.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
