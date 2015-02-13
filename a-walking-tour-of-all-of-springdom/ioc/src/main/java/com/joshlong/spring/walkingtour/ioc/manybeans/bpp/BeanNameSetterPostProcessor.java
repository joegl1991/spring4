package com.joshlong.spring.walkingtour.ioc.manybeans.bpp;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
/**
 * 
 * 
 * @author Celeritech Peru
 * @description: Se desea crear una anotación a nivel de atributo
 * que le indique al contenedor que debe setear el nombre del bean
 * en ese atributo. 
 * 
 * 
 */


@Component
public class BeanNameSetterPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		Field field = getFieldForBeanName(bean);
		if(field!=null){
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, bean, beanName);
		}
		return bean;
	}

	private Field getFieldForBeanName(Object bean) {
		Field[] fields = bean.getClass().getDeclaredFields();
		for(Field field: fields){
			BeanName beanNameAnnot = field.getAnnotation(BeanName.class);
			if(beanNameAnnot!=null){
				return field;
			}
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

}
