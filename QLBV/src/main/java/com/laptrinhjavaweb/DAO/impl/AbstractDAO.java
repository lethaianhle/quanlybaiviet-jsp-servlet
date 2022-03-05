package com.laptrinhjavaweb.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhjavaweb.DAO.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		Connection conn = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String user = "root";
//			String password = "123456";
//			String url = "jdbc:mysql://localhost:3306/qlbv";
			Class.forName(resourceBundle.getString("driverName"));
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			String url = resourceBundle.getString("url");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}

		return conn;
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> result = new ArrayList<T>();
		Connection conn = getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			preparedStatement = conn.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet));
			}
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if(result != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				conn.close();
			} catch (SQLException e) {
				return null;
			}
		}

		return result;
	}

	private void setParameter(PreparedStatement preparedStatement, Object... parameters) throws SQLException {
		for (int i = 0; i < parameters.length; i++) {
			Object parameter = parameters[i];
			int index = i + 1;
			if (parameter instanceof Long) {
				preparedStatement.setLong(index, (long) parameter);
			} else if (parameter instanceof String) {
				preparedStatement.setString(index, (String) parameter);
			} else if (parameter instanceof Integer) {
				preparedStatement.setInt(index, (Integer) parameter);
			} else if (parameter instanceof Timestamp) {
				preparedStatement.setTimestamp(index, (Timestamp) parameter);
			}
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			preparedStatement = conn.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public Long create(String sql, Object... parameters) {
		Long id = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(preparedStatement, parameters);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return null;
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			conn = getConnection();
			preparedStatement = conn.prepareStatement(sql);
			setParameter(preparedStatement, parameters);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				return 0;
			}
		}
		return count;
	}

}












