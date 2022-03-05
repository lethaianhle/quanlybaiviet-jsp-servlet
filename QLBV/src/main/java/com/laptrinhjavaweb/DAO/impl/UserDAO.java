package com.laptrinhjavaweb.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.DAO.IUserDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel get(Long userId) {
		String sql = "SELECT * FROM user WHERE user_id = ?";
		List<UserModel> list = new ArrayList<>();
		list = query(sql, new UserMapper(), userId);

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Long create(UserModel userModel) {
		return null;

	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findAll(Pageble page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel findByUserAndPassAndStatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.role_id = u.role_id");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> list = query(sql.toString(), new UserMapper(), userName, password, status);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Long registration(UserModel userModel) {
		String sql = "INSERT INTO user(username, password, fullname, status, role_id) values(?, ?, ?, ?, ?)";
		return create(sql, userModel.getUserName(), userModel.getPassword(), userModel.getFullName(), userModel.getStatus(), userModel.getRoleId());
	}

	@Override
	public UserModel findByUserName(String userName) {
		String sql = "SELECT * FROM user WHERE username = ?";
		List<UserModel> list = new ArrayList<>();
		list = query(sql, new UserMapper(), userName);

		return list.isEmpty() ? null : list.get(0);
	}



}
