package org.kaunghtetaung.jdbcderby;

import org.kaunghtetaung.jdbcderby.dao.JdbcDaoImpl;
import org.kaunghtetaung.jdbcderby.model.Circle;

public class JdbcDerbyApp {

	public static void main(String[] args) {
		Circle circle1 = new JdbcDaoImpl().getCircleById(1);
		System.out.println("Circle name = "+ circle1.getName());		
	}
}
