package org.kaunghtetaung.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJoinPoint {

	@Before("allGameMethods()")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Joinpoint = "+joinPoint.toString());
	}
	
	@Pointcut("within(org.kaunghtetaung.springaop.model.Game)")
	public void allGameMethods() {}

}
