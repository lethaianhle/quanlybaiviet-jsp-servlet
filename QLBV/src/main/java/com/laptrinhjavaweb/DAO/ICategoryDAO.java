package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	
	CategoryModel get(Long categoryId);
	
	CategoryModel findByCategoryCode(String categoryCode);
}
