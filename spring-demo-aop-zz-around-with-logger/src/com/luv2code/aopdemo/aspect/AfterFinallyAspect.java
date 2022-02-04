package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.AroundWithLoggerDemoApp;
 
@Aspect
@Component
@Order(4)
public class AfterFinallyAspect {
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>> Executing @After (finally) on method: " 
							+ method);
	
	}

}
