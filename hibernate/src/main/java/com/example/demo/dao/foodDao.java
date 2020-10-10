package com.example.demo.dao;

import com.example.demo.models.food;

public interface foodDao extends BaseDao<food> {

	void saveOrUpdate(food food);

}
