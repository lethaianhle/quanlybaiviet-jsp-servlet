package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface IUserDAO extends GenericDAO<UserModel>{
	
	UserModel findByUserAndPassAndStatus(String userName, String password, Integer status);

	UserModel get(Long newId);
	
	Long create(UserModel userModel);
	
	Long registration(UserModel userModel);
	
	UserModel findByUserName(String userName);
	
	int count();
	
	List<UserModel> findAll();
	
	List<UserModel> findAll(Pageble page);
	
	List<UserModel> findAll(Integer offset, Integer limit);
	
	List<UserModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
}
