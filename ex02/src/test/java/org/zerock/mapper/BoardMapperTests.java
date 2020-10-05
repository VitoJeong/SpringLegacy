package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


// 테스트 순서 mapper -> service -> controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	// @Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	//@Test
	public void textInsert() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	
		
	}
	
	// @Test
	public void textInsertSelectKey() {
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
		
		
	}
	
	// @Test
	public void testRead() {
		
		BoardVO board = mapper.read(19L);
		
		log.info(board);
	}
	
	//@Test
	public void testDelete() {
		
		log.info("Delete count : " + mapper.delete(3L));
		
	}

	@Test
	public void textUpdate() {
		
		BoardVO board = new BoardVO();
		board.setBno(6L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("newbie Updated");
		
		int count = mapper.update(board);
		
		log.info("Update Count : " + count);
		
		
	}
	
	
}
