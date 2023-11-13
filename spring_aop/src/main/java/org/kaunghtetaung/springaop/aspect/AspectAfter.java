package org.kaunghtetaung.springaop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectAfter {
	
	@After("execution(* org.kaunghtetaung.springaop.model.*.get*(..))")
	public void afterAdvice() {
		System.out.println("AfterAdvice is executed.");
	}

}
