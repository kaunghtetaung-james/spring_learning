package org.kaunghtetaung.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectAround {

	@Around("allGetters()")
	public Object aroundGetterAdvice(ProceedingJoinPoint pjp) {
		Object returnVal = null;

		try {
			System.out.println("Before aroundGetterAdvice");
			returnVal = pjp.proceed();
			System.out.println("After Returning aroundGetterAdvice");

		} catch (Throwable e) {
			System.out.println("After Throwing aroundGetterAdvice");
		}

		System.out.println("After Finally aroundGetterAdvice");
		return returnVal;
	}

	@AfterReturning(pointcut = "args(arg1)", returning = "returnVal")
	public void stringArgMethodsAfterReturning(String arg1, Object returnVal) {
		System.out.println("stringArgMethodsAfterReturning => value= " + arg1);
		System.out.println("stringArgMethodsAfterReturning => return = " + returnVal);
	}

	@AfterThrowing(pointcut = "args(arg1)", throwing = "ex")
	public void stringArgMethodsAfterThrowing(String arg1, RuntimeException ex) {
		System.out.println("stringArgMethodsAfterThrowing => value= " + arg1);
		System.out.println("stringArgMethodsAfterThrowing => exception= " + ex);
	}

	@Pointcut("execution(* get*(..))")
	public void allGetters() {
	}

	@Pointcut("execution(* set*(..))")
	public void allSetters() {
	}

}
