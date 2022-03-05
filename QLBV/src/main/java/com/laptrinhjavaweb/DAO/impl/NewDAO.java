package com.laptrinhjavaweb.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.DAO.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	private NewMapper newMapper = new NewMapper();

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		List<NewModel> listByCategoryId = new ArrayList<NewModel>();
		String sql = "SELECT * FROM news WHERE category_id = ?";

		listByCategoryId = super.query(sql, newMapper, categoryId);
		return listByCategoryId;
	}

	@Override
	public NewModel get(long newId) {
		String sql = "SELECT * FROM news WHERE new_id = ?";
		List<NewModel> list = new ArrayList<>();
		list = query(sql, new NewMapper(), newId);

		NewModel newModel = list.get(0);

		return list.isEmpty() ? null : newModel;
	}

	@Override
	public Long create(NewModel newModel) {
		String sql = "INSERT INTO news(title, thumbnail, description, content, created_date, created_by, category_id) values(?, ?, ?, ?, ?, ?, ?)";
		return create(sql, newModel.getTitle(), newModel.getThumbnail(), newModel.getDescription(),
				newModel.getContent(), newModel.getCreatedDate(), newModel.getCreatedBy(), newModel.getCategoryId());
	}

	public void delete(Long newId) {
		// delete all cmt da
		String sql = "DELETE FROM news WHERE new_id = ?";
		super.update(sql, newId);
	}

	public void update(NewModel newModel) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE news SET title = ?");
		sql.append(", thumbnail = ?, description = ?, content = ?");
		sql.append(", created_date = ?, modified_date = ?, created_by = ?, modified_by = ?, category_id = ?");
		sql.append(" WHERE new_id = ?");
		super.update(sql.toString(), newModel.getTitle(), newModel.getThumbnail(), newModel.getDescription(),
				newModel.getContent(), newModel.getCreatedDate(), newModel.getModifiedDate(), newModel.getCreatedBy(),
				newModel.getModifiedBy(), newModel.getCategoryId(), newModel.getNewId());
	}

	@Override
	public List<NewModel> findAll() {
		String sql = "SELECT * FROM news";
		List<NewModel> listNew = new ArrayList<>();
		listNew = query(sql, newMapper);
		return listNew;
	}

	@Override
	public int count() {
		String sql = "SELECT COUNT(*) FROM news";
		int count = count(sql);
		return count;
	}

	public List<NewModel> findAll(Integer offset, Integer limit) {
		String sql = "SELECT * FROM news LIMIT ?, ?";
		return query(sql, new NewMapper(), offset, limit);
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy) {
		String sql = "SELECT * FROM news ORDER BY ? ? LIMIT ?, ?";
		return query(sql, new NewMapper(), sortName, sortBy, offset, limit);
	}

	@Override
	public List<NewModel> findAll(Pageble page) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if(page.getSorter() != null) {
			sql.append(" ORDER BY " +page.getSorter().getSortName()+ " " +page.getSorter().getSortBy());
		}
		if(page.getOffSet() != null && page.getLimit() != null) {
			sql.append(" LIMIT " +page.getOffSet()+ ", " + page.getLimit()+ "");
		}
		return query(sql.toString(), new NewMapper());
	}

}
