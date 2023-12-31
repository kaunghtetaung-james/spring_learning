package org.kaunghtetaung.springdatasource.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.kaunghtetaung.springdatasource.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//to connect to the database and operate data
@Component
public class JdbcDaoImpl {
	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	//No longer required
	//private final String DRIVER_STR = "org.apache.derby.jdbc.ClientDriver";
	//private final String CON_STR = "jdbc:derby://localhost:1527/db;create=true";
	
	public Circle getCircleById(int id) {
		String sql = "SELECT * FROM circle WHERE id = ?";
		Connection connection = null;
		Circle circle = null;
		try {
			connection = dataSource.getConnection();
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
}
