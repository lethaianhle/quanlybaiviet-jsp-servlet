package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	//auto mapping data from resultSet to UserModel
	@Override
	public UserModel mapRow(ResultSet resultSet) {
		UserModel user = new UserModel();
		try {
			user.setUserId(resultSet.getLong("user_id"));
			user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setFullName(resultSet.getString("fullname"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("role_id"));
			
			if(resultSet.getTimestamp("created_date") != null) {
				user.setCreatedDate(resultSet.getTimestamp("created-date"));
			}
			if(resultSet.getTimestamp("modified_date") != null) {
				user.setModifiedDate(resultSet.getTimestamp("modified_date"));
			}
			if(resultSet.getString("created_by") != null) {
				user.setCreatedBy(resultSet.getString("created_by"));
			}
			if(resultSet.getString("modified_by") != null) {
				user.setModifiedBy(resultSet.getString("modified_by"));
			}
			
			try {
				RoleModel role = new RoleModel();
				role.setRoleCode(resultSet.getString("role_code"));
				role.setRoleName(resultSet.getString("role_name"));
				user.setRole(role);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} catch (SQLException e) {
			return null;
		}
		return user;
	}

}
