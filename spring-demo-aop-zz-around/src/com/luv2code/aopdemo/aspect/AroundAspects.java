package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
@Order(5)
	public class AroundAspects {
		@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
		public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable {
			
			String method = theProceedingJoinPoint.getSignature().toShortString();
			System.out.println("\n=====>>> Executing @Around   on method: "+ method);
			
			long begin = System.currentTimeMillis();
			
			Object result = theProceedingJoinPoint.proceed();
			
			long end = System.currentTimeMillis();
			
			long duration = end-begin;
			System.out.println("\n =============> Duration " +duration/1000.0 + " seconds");
			
			
			
			
			
		return result;
			
		}

}
