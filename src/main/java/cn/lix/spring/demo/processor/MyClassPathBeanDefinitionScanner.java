package cn.lix.spring.demo.processor;

import cn.lix.spring.demo.interfaces.MyService;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AssignableTypeFilter;

import java.util.Set;

/**
 * 自定义扫描器
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {


    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        // 不使用默认的过滤器（org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider.registerDefaultFilters）
        super(registry, false);
    }


    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        System.out.println("doscan.....");
        return super.doScan(basePackages);
    }

    /**
     * 添加自己定义的过滤类型，可以是注解，可以是接口，可以是类
     * 扫描我们自己定义的接口类交由spring管理
     */
    protected void registerFilters() {
        addIncludeFilter(new AssignableTypeFilter(MyService.class));
    }
}
