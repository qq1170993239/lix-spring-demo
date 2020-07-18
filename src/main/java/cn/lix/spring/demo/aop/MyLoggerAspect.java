package cn.lix.spring.demo.aop;

import cn.lix.spring.demo.annotations.MyLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggerAspect {


    @Around(value = "@annotation(logger)", argNames = "joinPoint,logger")
    public Object sayHello(ProceedingJoinPoint joinPoint, MyLogger logger) {
        Object obj = null;
        try {
            System.out.println(logger.name() + "  do somethings start....");
            obj = joinPoint.proceed();
            System.out.println(logger.name() + "  do somethings end....");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            System.out.println(logger.name() + "  finally....");
        }
        return obj;
    }
}
