package org.kaunghtetaung.jdbcderby.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.kaunghtetaung.jdbcderby.model.Circle;

//to connect to the database and operate data
public class JdbcDaoImpl {
	
	private final String DRIVER_STR = "org.apache.derby.jdbc.ClientDriver";
	private final String CON_STR = "jdbc:derby://localhost:1527/db";
	
	public Circle getCircleById(int id) {
		String sql = "SELECT * FROM circle WHERE id = ?";
		Connection connection = getDbConnection();
		Circle circle = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
						
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(id, rs.getString("name"));
			}
			rs.close();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		return circle;	
				
	}
	
	public Connection getDbConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER_STR).newInstance();
			connection = DriverManager.getConnection(CON_STR);			
		} catch (Exception e) {			
			e.printStackTrace();
		} 
		return connection;
	}
}
