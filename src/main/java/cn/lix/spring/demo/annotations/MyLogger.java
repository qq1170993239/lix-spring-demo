package cn.lix.spring.demo.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface MyLogger {

    String name() default "MyLogger";

    boolean test() default false;

}
