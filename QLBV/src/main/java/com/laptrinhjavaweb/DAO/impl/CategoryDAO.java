package com.laptrinhjavaweb.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.DAO.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	private CategoryMapper categoryMapper = new CategoryMapper();

	@Override
	public List<CategoryModel> findAll() {
		List<CategoryModel> listAllCategory = new ArrayList<>();
		String sql = "SELECT * FROM category";

		listAllCategory = super.query(sql, categoryMapper);

		return listAllCategory;
	}

	@Override
	public CategoryModel get(Long categoryId) {
		String sql = "SELECT * FROM category WHERE category_id = ?";
		List<CategoryModel> list = new ArrayList<>();
		list = query(sql, new CategoryMapper(), categoryId);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public CategoryModel findByCategoryCode(String categoryCode) {
		String sql = "SELECT * FROM category WHERE category_code = ?";
		List<CategoryModel> list = new ArrayList<>();
		list = query(sql, new CategoryMapper(), categoryCode);

		return list.isEmpty() ? null : list.get(0);
	}

}
