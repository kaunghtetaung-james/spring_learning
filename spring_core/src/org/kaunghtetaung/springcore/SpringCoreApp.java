package org.kaunghtetaung.springcore;

import org.kaunghtetaung.springcore.model.Laptop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCoreApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Laptop laptop = context.getBean("laptop", Laptop.class);
		
		laptop.setName("Lenovo Gaming Ideapad 3");
		laptop.setPrice(1000);
		laptop.setBrand("Lenovo");
		
		System.out.println("**Laptop Information**");
		System.out.println(laptop);
	}

}
