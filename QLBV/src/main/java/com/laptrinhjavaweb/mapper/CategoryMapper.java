package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setCategoryId(resultSet.getLong("category_id"));
			categoryModel.setCategoryName(resultSet.getString("category_name"));
			categoryModel.setCategoryCode(resultSet.getString("category_code"));
			
			if(resultSet.getTimestamp("created_date") != null) {
				categoryModel.setCreatedDate(resultSet.getTimestamp("created_date"));
			}
			if(resultSet.getTimestamp("modified_date") != null) {
				categoryModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
			}
			if(resultSet.getString("created_by") != null) {
				categoryModel.setCreatedBy(resultSet.getString("created_by"));
			}
			if(resultSet.getString("modified_by") != null) {
				categoryModel.setModifiedBy(resultSet.getString("modified_by"));
			}
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
