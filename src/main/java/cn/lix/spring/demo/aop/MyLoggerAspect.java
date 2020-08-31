package cn.lix.spring.demo.aop;

import cn.lix.spring.demo.annotations.MyLogger;
import cn.lix.spring.demo.utils.LogUtils;
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
            LogUtils.log().info(logger.name() + "  do somethings start....");
            obj = joinPoint.proceed();
            LogUtils.log().info(logger.name() + "  do somethings end....");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            LogUtils.log().info(logger.name() + "  finally....");
        }
        return obj;
    }
}
