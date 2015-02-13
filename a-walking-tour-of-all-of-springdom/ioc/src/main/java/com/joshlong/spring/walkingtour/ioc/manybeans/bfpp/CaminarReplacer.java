package com.joshlong.spring.walkingtour.ioc.manybeans.bfpp;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component
public class CaminarReplacer implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println("Caminar generico");
		return null;
	}

}
