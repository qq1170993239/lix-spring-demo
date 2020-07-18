package cn.lix.spring.demo.aop;

import cn.lix.spring.demo.annotations.ExceptionHandler;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description  我们的代理增强类，需要增强的方法写在这里面
 * @Author  lix <sclx1220@163.com>
 * @Date 2020/7/17
 */
public class ExceptionHandlerObject implements MethodInterceptor {

    private Object target;

    private Class type;

    public ExceptionHandlerObject(Object target,  ExceptionHandler handler) {
        System.out.println("生成代理对象：" + target.getClass());
        this.target = target;
        this.type = handler.value();
    }

    public Object getInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(method.getModifiers() != Modifier.PUBLIC){
            return method.invoke(target, args);
        }
        Object result = null;
        try {
            System.out.println("ExceptionHandlerObject开始。。。");
            result = methodProxy.invokeSuper(object, args);
            System.out.println("ExceptionHandlerObject结束。。。");
        } catch (Throwable throwable) {
            // 如果是该类型或是其子类就处理
            if(type.isAssignableFrom(throwable.getClass())){
                System.out.println("ExceptionHandlerObject统一异常处理。。。");
            }
        } finally {
            System.out.println("ExceptionHandlerObject---finally。。。");
        }
        return result;
    }
}
