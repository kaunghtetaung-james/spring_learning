package org.kaunghtetaung.springdatasource.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.kaunghtetaung.springdatasource.model.Circle;
import org.kaunghtetaung.springdatasource.model.Triangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

//to connect to the database and operate data
@Component
public class DaoSupportImpl extends NamedParameterJdbcDaoSupport{
	//NamedParameterJdbcTemplate test
	public Triangle getTriangleById(int id) {
		String sql = "SELECT * FROM triangle WHERE id = :triangleId";
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("triangleId", id);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, new TriangleMapper());
	}
		
	private static final class TriangleMapper implements RowMapper<Triangle> {

		@Override
		public Triangle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		//arg01 = the ResultSet got from executing sql by jdbcTemplate
		//arg02 = row number in the resultSet of arg01
		//mapRow() method is called as many times as the number of rows in the resultSet
		//For each call, resultSet will be the same, but the rowNum will be incremented each time to map each row of the resultSet
			Triangle triangle = new Triangle(resultSet.getInt("id"), 
									   resultSet.getString("name"));
			return triangle;
		}
		
	}
	
}
