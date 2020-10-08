package org.zerock.domain;

import lombok.Data;

@Data
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	public PageDTO(Criteria cri, int total) {

		this.cri = cri;
		this.total = total;
		
		// 페이지 번호가 5개씩 보임
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5;
		this.startPage = this.endPage - 4;
		
		// 끝 번호가 5의 배수가 아니라면 보여줄 진짜 끝번호
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
		
	}
	
	
}
