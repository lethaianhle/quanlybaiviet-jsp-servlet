package com.laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.IUserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel create(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel get(Long newId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel update(UserModel userModel) {
		// TODO Auto-generated method stub
		return null;
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
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel findByUserAndPassAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserAndPassAndStatus(userName, password, status);
	}

	@Override
	public UserModel registration(UserModel userModel) {
		userModel.setRoleId(2L);
		userModel.setStatus(1);
		Long userId = userDAO.registration(userModel);
		UserModel model = userDAO.get(userId);
		return model;
	}

	@Override
	public UserModel findByUserName(String userName) {
		return userDAO.findByUserName(userName);
	}
	

}
