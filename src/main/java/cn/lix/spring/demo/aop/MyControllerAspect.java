package cn.lix.spring.demo.aop;

import cn.lix.spring.demo.annotations.ExceptionHandler;
import cn.lix.spring.demo.interfaces.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description  将我们的代理类交由spring管理。
 * 注：MyService接口相当于@Component功能，这里是我自定的，
 * 这块可以查看我的另一篇博文：{@Link https://blog.csdn.net/qq1170993239/article/details/106999915}
 * @Author  lix <sclx1220@163.com>
 * @Date 2020/7/17
 */
public class MyControllerAspect implements MyService, BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        ExceptionHandler annotation = bean.getClass().getAnnotation(ExceptionHandler.class);
        if(annotation == null){
            return bean;
        }
        ExceptionHandlerObject handlerObject = new ExceptionHandlerObject(bean, annotation);
        // 使用cglib创建我们的代理类
        return handlerObject.getInstance();
    }
}
