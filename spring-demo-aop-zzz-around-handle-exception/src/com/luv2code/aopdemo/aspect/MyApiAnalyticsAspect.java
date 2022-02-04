package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		myLogger.info("\n=====>>> Performing API analytics");		
	}

}
