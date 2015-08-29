package com.joshlong.spring.walkingtour.ioc.basicioc.qualifiers;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.joshlong.spring.walkingtour.ioc.basicioc.qualifiers.annotation.AndroidStore;
import com.joshlong.spring.walkingtour.ioc.basicioc.qualifiers.annotation.IOsStore;


public class Client {



    @Inject
    @AndroidStore
    private BookShop androidByQualifierAnnotation;

    @Inject
    @IOsStore
    private BookShop iosByQualifierAnnotation;

    @Inject
    @Qualifier("ios")
    private BookShop iosBookshopByName;

    @Inject
    @Qualifier("android")
    private BookShop androidBookshopByName;

    @PostConstruct
    public void start() throws Throwable {
        System.out.println("android store by name: " + ToStringBuilder.reflectionToString(this.androidBookshopByName));
        System.out.println("ios store by name: " + ToStringBuilder.reflectionToString(this.iosBookshopByName));

        System.out.println("android store by qualifier annotation: " + ToStringBuilder.reflectionToString(this.androidByQualifierAnnotation));
        System.out.println("ios store by qualifier annotation: " + ToStringBuilder.reflectionToString(this.iosByQualifierAnnotation));
    }
}
