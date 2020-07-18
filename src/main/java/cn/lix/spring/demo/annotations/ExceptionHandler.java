package cn.lix.spring.demo.annotations;

import java.lang.annotation.*;

/**
 * @Description  统一异常处理注解
 * @Author  lix <sclx1220@163.com>
 * @Date 2020/7/17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface ExceptionHandler {

    Class value() default RuntimeException.class;

}
