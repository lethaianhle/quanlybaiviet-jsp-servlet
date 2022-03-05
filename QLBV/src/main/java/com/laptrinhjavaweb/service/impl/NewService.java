package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.DAO.ICategoryDAO;
import com.laptrinhjavaweb.DAO.impl.NewDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.service.INewService;

public class NewService implements INewService{
	
	private NewDAO newDAO = new NewDAO();
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel get(long newId) {
		NewModel newModel = newDAO.get(newId);
		CategoryModel categoryModel = categoryDAO.get(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCategoryCode());
		return newModel;
	}

	@Override
	public NewModel create(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category = categoryDAO.findByCategoryCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getCategoryId());
		newModel.setCategoryName(category.getCategoryName());
		newModel.setCategory(category);
		Long id = newDAO.create(newModel);
		return newDAO.get(id);
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			newDAO.delete(id);
		}
	}
	
	@Override
	public NewModel update(NewModel newModel) {
		NewModel existNew = newDAO.get(newModel.getNewId());
		CategoryModel category = categoryDAO.findByCategoryCode(newModel.getCategoryCode());
		
		newModel.setCategoryId(category.getCategoryId());
		newModel.setCreatedDate(existNew.getCreatedDate());
		newModel.setCreatedBy(existNew.getCreatedBy());
		newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
		newDAO.update(newModel);
		
		return newDAO.get(newModel.getNewId());
	}

	@Override
	public List<NewModel> findAll() {
		return newDAO.findAll();
	}

	@Override
	public int count() {
		return newDAO.count();
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit) {
		// TODO Auto-generated method stub
		return newDAO.findAll(offset, limit);
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
		return newDAO.findAll(offset, limit, sortName, sortBy);
	}

	@Override
	public List<NewModel> findAll(Pageble page) {
		// TODO Auto-generated method stub
		return newDAO.findAll(page);
	}



}
