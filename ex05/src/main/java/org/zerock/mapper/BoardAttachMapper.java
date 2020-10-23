package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardAttachVO;

public interface BoardAttachMapper {
	
	public void insert(BoardAttachVO vo);
	
	public void delete(String uuid);
	
	// 게시글 번호에 해당하는 업로드파일의 리스트를 반환받는 메서드
	public List<BoardAttachVO> findByBno(Long bno);
	
	public void deleteAll(Long bno);
	
	// 이전 날짜들 중 DB에 없지만 등록된 파일의 리스를 반환받는 메서드
	public List<BoardAttachVO> getOldFiles();
	
}
