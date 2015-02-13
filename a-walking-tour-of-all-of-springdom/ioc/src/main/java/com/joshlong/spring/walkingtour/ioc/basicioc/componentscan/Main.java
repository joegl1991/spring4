package com.joshlong.spring.walkingtour.ioc.basicioc.componentscan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joshlong.spring.walkingtour.ioc.basicioc.componentscan.CustomerService;

public class Main {
    public static void main(String[] args) throws Throwable {
        String pkgName = Config.class.getPackage().getName();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(pkgName);
        
        
        CustomerService customerService = 
        		ac.getBean(CustomerService.class);
        
        
        ac.registerShutdownHook();
    }
}
