package org.kaunghtetaung.springdatasource.main;

import org.kaunghtetaung.springdatasource.dao.DaoSupportImpl;
import org.kaunghtetaung.springdatasource.dao.JdbcDaoImpl;
import org.kaunghtetaung.springdatasource.model.Circle;
import org.kaunghtetaung.springdatasource.model.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDerbyApp {

	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		//JdbcDaoImpl jdbcDaoImpl = context.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		DaoSupportImpl daoSupportImpl = context.getBean("daoSupportImpl", DaoSupportImpl.class);
		
		//System.out.println("Circle count: "+ jdbcDaoImpl.getCircleCount());
		//System.out.println("Circle name: "+ jdbcDaoImpl.getCircleNameById(1));
		//System.out.println("Circle name = " + jdbcDaoImpl.getCircleById(2).getName());
			
		//jdbcDaoImpl.insertCircle(new Circle(2,"2nd circle"));
		//System.out.println("Circle list size: "+ jdbcDaoImpl.getAllCircles().size());
		
		//jdbcDaoImpl.createTriangleTable();
		//jdbcDaoImpl.insertTriangle(new Triangle(1, "1st Triangle"));
		//jdbcDaoImpl.insertTriangle(new Triangle(2, "2nd Triangle"));
		
		System.out.println("Triangle name: " + daoSupportImpl.getTriangleById(1).getName());
	}
}
