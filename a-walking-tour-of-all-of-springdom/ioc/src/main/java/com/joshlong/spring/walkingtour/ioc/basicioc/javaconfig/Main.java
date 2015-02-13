package com.joshlong.spring.walkingtour.ioc.basicioc.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joshlong.spring.walkingtour.ioc.basicioc.javaconfig.CustomerService;

public class Main {
    public static void main(String[] args) throws Throwable {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        
        CustomerService customerService = 
        		annotationConfigApplicationContext.getBean(CustomerService.class);
        assert null != customerService : "the customerService reference can't be null!";
    }
}
