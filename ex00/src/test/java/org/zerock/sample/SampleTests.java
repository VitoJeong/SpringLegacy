package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	// lombok을 이용해 setRestaurant를 자동으로 생성
	//	- @Autowired를 통해 해당 인스턴스 변수가 자동으로 주입해달라고 요청
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		// 변수가 Null이 아니어야만 테스트가 성공
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("-----------------------");
		log.info(restaurant.getChef());
	}
}
