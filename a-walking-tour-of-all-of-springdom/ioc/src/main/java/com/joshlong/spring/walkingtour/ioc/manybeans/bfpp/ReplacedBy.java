package com.joshlong.spring.walkingtour.ioc.manybeans.bfpp;


@java.lang.annotation.Target({java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Documented
public @interface ReplacedBy {

	java.lang.String value() default "";
}
