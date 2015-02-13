package com.joshlong.spring.walkingtour.ioc.manybeans.bpp;

import org.springframework.stereotype.Component;

@Component
public class Carro {

	@BeanName
	private String beanName;

	@Override
	public String toString() {
		return "Carro [beanName=" + beanName + "]";
	}
	
	
}
