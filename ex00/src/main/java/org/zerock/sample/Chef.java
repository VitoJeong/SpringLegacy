package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	/* 
	 * 
	 * @Component 
	 *  -> 해당클래스(Chef)가 스프링에서 객체로 만들어서 관리하는 대상임을 명시
	 * 
	 * @Data (Lombok에서 제공)
	 *  -> @ToString, @Getter/@Setter, @EqualsAndHashCode를 결합한 형태로 자주 사용되는 모든 메서드 생성
	 * 
	 */
}
