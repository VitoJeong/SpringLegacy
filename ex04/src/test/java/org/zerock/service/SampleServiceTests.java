package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SampleServiceTests {

  @Setter(onMethod_ = @Autowired)
  private SampleService service;
  
  
  // @Test
  public void testClass() {
    
    log.info(service);
    log.info(service.getClass().getName());    
    // service는 toString()결과 이므로 getClass().getName() 사용
    // -> ServiceImple클래스의 인스턴스가 아닌 다이나믹 프록시 기법이 적용된 Proxy클래스의 인스턴스
    
  }
  
  @Test
  public void testAdd() throws Exception {
    
    log.info(service.doAdd("123", "456"));
    // @Around가 @Before를 실행시키는(감싸는) 형태로 동작
    
  }
  
  //@Test
  public void testAddError() throws Exception {
    
    log.info(service.doAdd("123", "ABC"));
    
  }  


  
}

