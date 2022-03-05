package com.laptrinhjavaweb.DAO;

import java.util.List;

import com.laptrinhjavaweb.mapper.RowMapper;

public interface GenericDAO<T> {
	<T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	
//	<T> T get(long id);
	
	void update(String sql, Object... parameters);
	
	Long create(String sql, Object... parameters);
	
	int count(String sql, Object... parameters);
	
}
