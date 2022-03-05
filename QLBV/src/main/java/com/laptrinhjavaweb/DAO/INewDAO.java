package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO extends GenericDAO<NewModel> {

	List<NewModel> findByCategoryId(Long categoryId);
	
	NewModel get(long newId);
	
	Long create(NewModel newModel);
	
	int count();
	
	List<NewModel> findAll();
	
	List<NewModel> findAll(Pageble page);
	
	List<NewModel> findAll(Integer offset, Integer limit);
	
	List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
}
