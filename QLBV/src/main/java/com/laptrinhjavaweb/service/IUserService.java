package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface IUserService {
	UserModel findByUserAndPassAndStatus(String userName, String password, Integer status);
	
	UserModel create(UserModel userModel);
	
	UserModel get(Long newId);
	
	void delete(Long[] ids);
	
	UserModel update(UserModel userModel);
	
	List<UserModel> findAll();
	
	List<UserModel> findAll(Pageble page);
	
	List<UserModel> findAll(Integer offset, Integer limit);
	
	List<UserModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	
	int count();
	
	UserModel registration(UserModel userModel);
	
	public UserModel findByUserName(String userName);

}
