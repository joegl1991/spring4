package com.mycompany.reyes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReyMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext 
		   fabricaSpring = 
		   new ClassPathXmlApplicationContext("reyes.xml");
		
		//Interface = Class
		Rey rey = fabricaSpring.getBean(Rey.class);
		rey.embarcarEnAventura();
		fabricaSpring.close();

	}

}
