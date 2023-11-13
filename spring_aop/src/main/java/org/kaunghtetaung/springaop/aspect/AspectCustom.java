package org.kaunghtetaung.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectCustom {
	
	@Around("@annotation(org.kaunghtetaung.springaop.aspect.annotation.CustomAspectAnnotation01)")
	public Object customAroundAdvice(ProceedingJoinPoint pjp) {
		Object returnVal = null;

		try {
			System.out.println("Before customAroundAdvice");
			returnVal = pjp.proceed();
			System.out.println("After Returning customAroundAdvice");

		} catch (Throwable e) {
			System.out.println("After Throwing customAroundAdvice");
		}

		System.out.println("After Finally customAroundAdvice");
		return returnVal;
	}

}
