package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
 
@Aspect
@Component
@Order(5)
	public class AroundAspects {
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
		@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
		public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable {
			
			String method = theProceedingJoinPoint.getSignature().toShortString();
			myLogger.info("\n=====>>> Executing @Around   on method: "+ method);
			
			long begin = System.currentTimeMillis();
			
			Object result = theProceedingJoinPoint.proceed();
			
			long end = System.currentTimeMillis();
			
			long duration = end-begin;
			myLogger.info("\n =============> Duration " +duration/1000.0 + " seconds");
			
			
			
			
			
		return result;
			
		}

}
