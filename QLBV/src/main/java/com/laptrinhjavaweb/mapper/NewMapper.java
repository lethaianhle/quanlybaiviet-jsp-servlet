package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel> {

	// auto mapping data from ResultSet to NewModel
	@Override
	public NewModel mapRow(ResultSet resultSet) {
		NewModel newModel = new NewModel();
		try {
			newModel.setNewId(resultSet.getLong("new_id"));
			newModel.setTitle(resultSet.getString("title"));
			newModel.setThumbnail(resultSet.getString("thumbnail"));
			newModel.setDescription(resultSet.getString("description"));
			newModel.setContent(resultSet.getString("content"));
			
			if(resultSet.getTimestamp("created_date") != null) {
				newModel.setCreatedDate(resultSet.getTimestamp("created_date"));
			}
			if(resultSet.getTimestamp("modified_date") != null) {
				newModel.setModifiedDate(resultSet.getTimestamp("modified_date"));
			}
			if(resultSet.getString("created_by") != null) {
				newModel.setCreatedBy(resultSet.getString("created_by"));
			}
			if(resultSet.getString("modified_by") != null) {
				newModel.setModifiedBy(resultSet.getString("modified_by"));
			}
			
			newModel.setCategoryId(resultSet.getLong("category_id"));

		} catch (SQLException e) {
			return null;
		}

		return newModel;
	}

}
