package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewService {
	List<NewModel> findByCategoryId(Long categoryId);
	
	NewModel create(NewModel newModel);
	
	NewModel get(long newId);
	
	void delete(long[] ids);
	
	NewModel update(NewModel newModel);
	
	List<NewModel> findAll();
	
	List<NewModel> findAll(Pageble page);
	
	List<NewModel> findAll(Integer offset, Integer limit);
	
	List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	
	int count();
}
