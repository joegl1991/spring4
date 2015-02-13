package com.joshlong.spring.walkingtour.ioc.manybeans.bfpp;

import org.springframework.stereotype.Component;

@Component
public class Pintor {
	
	@ReplacedBy("caminarReplacer")
	public void caminar(){
		System.out.println("caminar como pintor");
	}
}
