package org.kaunghtetaung.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectBefore {

	@Before("execution(public String getName())")
	public void beforeAdvice() {
		System.out.println("BeforeAdvice is executed.");
	}

}
