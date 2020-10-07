package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
public class Criteria {
	// 요청 페이지번호
  private int pageNum;
  // 한 페이지당 보여줄 데이터의 개수
  private int amount;
  
  private String type;
  private String keyword;

  public Criteria() {
	// 기본값 처리
    this(1, 10);
  }

  public Criteria(int pageNum, int amount) {
    this.pageNum = pageNum;
    this.amount = amount;
  }
  
  public String[] getTypeArr() {
	  return type == null? new String [] {} : type.split("");
  }
  
  public String getListLink() {
	  
	  // queryParam필요한 파라미터 손쉽게 추가 가능, 한글처리 신경 쓰지 않아도됨.
	  UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
			  .queryParam("pageNum", this.pageNum)
			  .queryParam("amount", this.getAmount())
			  .queryParam("type", this.getType())
			  .queryParam("keyword", this.getKeyword());
	  
	  return builder.toUriString();
	 

  }
  
}
