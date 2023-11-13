package org.kaunghtetaung.springaop;

import org.kaunghtetaung.springaop.model.Game;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopApp 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Game game = context.getBean("game", Game.class);
		
		//testing AfterThrowing Aspect
		/*
		 * game.setDescription("Dota 2 Gold Edition");
		 * System.out.println(game.getDescription());
		 */
		
		//testing AfterReturning Aspect
		/*
		 * game.setName("CSGO"); 
		 * System.out.println(game.getName());
		 */
		
		//testing custom aspect annotation
		/* System.out.println(game.getCompany()); */
		
		//testing aspect joinpoint
		System.out.println(game.getName());
    }
}
