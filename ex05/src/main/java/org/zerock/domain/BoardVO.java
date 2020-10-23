package org.zerock.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardVO {

  private Long bno;
  private String title;
  private String content;
  private String writer;
  private Date regdate;
  private Date updateDate;
  
  // 게시글의 댓글의 수
  private int replyCnt;
  
  // 게시글에 포함된 파일들을 처리
  private List<BoardAttachVO> attachList;
  
}
