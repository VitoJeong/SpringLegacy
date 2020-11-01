package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;


// @Aspect -> 해당 클래스 객체가 Aspect를 구현한 것임으로 나타내기 위해서 사용
// @Component -> Bean객체로 등록하는 스프링 설정
@Aspect 
@Log4j
@Component
public class LogAdvice {
	
	// @Before -> Target(메서드, 클래스)의 JoinPoint를 호출하기 전에 실행시키기 위해 사용
	// execution -> AspectJ의 표현식 (접근제한자와 특정 메서드기준으로 Pointcut을 설정) 
	@Before( "execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("===================");
	}
	
	// Pointcut설정
	// doAdd() -> 메서드 명시, 파라미터 타입 지정
	// args() -> 변수명 지정
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	  public void logBeforeWithParam(String str1, String str2) {

	   log.info("str1: " + str1);
	   log.info("str2: " + str2);
	}  
	
	// @AfterThrowing -> Target메서드가 예외를 발생한 후에 동작 
	// 	-> pointcut과 throwing 속성 지정
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
	    
	  log.info("Exception....!!!!");
	  log.info("exception: "+ exception);
	  
	}
	  
	// @Around -> 직접 대상 메서드를 실행할 수 있는 권한을 가짐
	//	-> 적용 메서드는 void가 아닌 타입으로 설정해야하고, 메서드의 실형 결과 역시 직접 반환 하는 형태로 작성!
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	// ProceedingJoinPoint -> @Around와 결합해서 파라미터나 예외등을 처리할 수 있음.
	//	-> Target이나 파라미터등을 파악하고, 직접 실행을 결정할 수 있음!
	public Object logTime( ProceedingJoinPoint pjp) {
	    
	  long start = System.currentTimeMillis();
	    
	  log.info("Target: " + pjp.getTarget());
	  log.info("Param: " + Arrays.toString(pjp.getArgs()));
	    
	    
	  //invoke method 
	  Object result = null;
	  
	  try {
	    result = pjp.proceed();
	  } catch (Throwable e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	  }
	   
	  long end = System.currentTimeMillis();
	   
	  log.info("TIME: "  + (end - start));
	   
	  return result;
	}

}
