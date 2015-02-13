package com.joshlong.spring.walkingtour.ioc.manybeans.bfpp;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.MethodOverride;
import org.springframework.beans.factory.support.MethodOverrides;
import org.springframework.beans.factory.support.ReplaceOverride;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;

@Component
public class MethodReplacerDecoratorFactoryPostProcessor 
	implements BeanFactoryPostProcessor{

	private static final String REPLACED_BY_CLASS_NAME = ReplacedBy.class.getName();
	
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		for(String beanDefinitionName: beanDefinitionNames){
			BeanDefinition beanDefinition = 
					beanFactory.getBeanDefinition(beanDefinitionName);
			if(beanDefinition instanceof ScannedGenericBeanDefinition){
				ScannedGenericBeanDefinition scannedBeanDefinition = 
						(ScannedGenericBeanDefinition) beanDefinition;
				Set<MethodMetadata> methodsMetadata = 
						scannedBeanDefinition.getMetadata().getAnnotatedMethods(REPLACED_BY_CLASS_NAME);
				if(methodsMetadata.size()>0){
					configureMethodsToBeOverriden(scannedBeanDefinition, methodsMetadata);
				}
				
				
			}
		}
		
	}

	private void configureMethodsToBeOverriden(
			ScannedGenericBeanDefinition scannedBeanDefinition,
			Set<MethodMetadata> methodsMetadata) {
		MethodOverrides mo = new MethodOverrides();
		
		for(MethodMetadata methodMetadata: methodsMetadata){
			String methodName = methodMetadata.getMethodName();
			Map<String, Object> attributes = 
					methodMetadata.getAnnotationAttributes(REPLACED_BY_CLASS_NAME);
			MethodOverride methodOverride = new ReplaceOverride(methodName, (String) attributes.get("value"));
			mo.addOverride(methodOverride);
		}
		scannedBeanDefinition.setMethodOverrides(mo);
		
	}

	
}
