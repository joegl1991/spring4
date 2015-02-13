package com.joshlong.spring.walkingtour.ioc.manybeans.bfpp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.joshlong.spring.walkingtour.ioc.manybeans.Cat;
import com.joshlong.spring.walkingtour.ioc.manybeans.Dog;
import com.joshlong.spring.walkingtour.ioc.manybeans.bfpp.AnimalFarmConfig;

public class Main {
    public static void main(String[] args) throws Throwable {

        String pkgName = AnimalFarmConfig.class.getPackage().getName();
        AnnotationConfigApplicationContext 
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(pkgName);
        
      
        
        
        Cat cat = annotationConfigApplicationContext.getBean(Cat.class);
        cat.meow();

        Dog dog = annotationConfigApplicationContext.getBean(Dog.class);
        dog.bark();
        
        annotationConfigApplicationContext.registerShutdownHook();
        
        Pintor pintor = annotationConfigApplicationContext.getBean(Pintor.class);
        pintor.caminar();
    }

}
