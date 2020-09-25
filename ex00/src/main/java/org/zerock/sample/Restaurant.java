package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
	
	@Setter(onMethod_ = { @Autowired })
	private Chef chef;
	
	/*
	 * @Setter
	 *  -> setter 메서드를 생성 (onMethod : 메서드에 추가할 어노테이션을 지정)
	 * 
	 * @Autowired
	 *  -> 해당 객체(Restaurant)가 특정한 객체(Chef)에 의존적이므로 해당 타입의 빈을 주입해달라는 표시
	 * 
	 */
}
