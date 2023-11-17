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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

//to connect to the database and operate data
@Component
public class JdbcDaoImpl {
	
	//private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	//getters and setters
	
	//public DataSource getDataSource() {
	//	return dataSource;
	//}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
			
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM circle";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public String getCircleNameById(int id) {
		String sql = "SELECT name FROM circle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
	}
	
	public Circle getCircleById(int id) {
		String sql = "SELECT * FROM circle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new CircleMapper());
	}
	
	public List<Circle> getAllCircles() {
		String sql = "SELECT * FROM circle";
		
		//can skip 2nd argument (parameters in sql) if not needed
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public Triangle getTriangleById(int id) {
		String sql = "SELECT * FROM triangle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new TriangleMapper());
	}
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO circle (id, name) VALUES (?,?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	//NamedParameterJdbcTemplate test
	public void insertTriangle(Triangle triangle) {
		String sql = "INSERT INTO triangle (id, name) VALUES (:triangleId, :triangleName)";
		MapSqlParameterSource namedParameters= new MapSqlParameterSource();
		namedParameters.addValue("triangleId", triangle.getId());
		namedParameters.addValue("triangleName", triangle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE triangle (id INTEGER, name VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		//arg01 = the ResultSet got from executing sql by jdbcTemplate
		//arg02 = row number in the resultSet of arg01
		//mapRow() method is called as many times as the number of rows in the resultSet
		//For each call, resultSet will be the same, but the rowNum will be incremented each time to map each row of the resultSet
			Circle circle = new Circle(resultSet.getInt("id"), 
									   resultSet.getString("name"));
			return circle;
		}
		
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
