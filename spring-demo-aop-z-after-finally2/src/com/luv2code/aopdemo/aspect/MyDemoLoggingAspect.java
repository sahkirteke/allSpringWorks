package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component 
@Order(2)
public class MyDemoLoggingAspect { 
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFinfAccountsAdvice(
			JoinPoint theJoinPoint , Throwable theExc) {
		

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =============> Executing @AfterTrowing on method" +method);
		
		System.out.println("\n ===============> the expeption is " +theExc);
	}
	
	@AfterReturning(
			pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint , List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =============> Executing @AfterReturning on method" +method);
		
		System.out.println("\n =============> result is" +result);
		
		
		convertAccountNameToUpperCase(result);
		System.out.println("\n =============> result is" +result);
	}
	
	
	private void convertAccountNameToUpperCase(List<Account> result) {
		 
		for (Account tempAccount: result) {
			
			String theUpperName= tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
			
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { 
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
		MethodSignature methoSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("method : " +methoSig);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				Account theAccount = (Account) tempArg;
				System.out.println("account name  : " + theAccount.getName());
				System.out.println("account level  : " + theAccount.getLevel());
			}
		}
		
		
	} 
	
}










