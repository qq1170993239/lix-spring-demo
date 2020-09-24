package cn.lix.spring.demo;

import cn.lix.spring.demo.config.TestPropertySourceFactory;
import cn.lix.spring.demo.imports.TestImportSelectors;
import cn.lix.spring.demo.utils.LogUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Import(TestImportSelectors.class)
@SpringBootApplication
@MapperScan("cn.lix.spring.demo.dao")
@PropertySource(value = "", factory = TestPropertySourceFactory.class)
public class SpringDemoApplication {

    @Value("${properties.test.name}")
    private String author;

    public static void main(String[] args) {
        // 保留JDK动态代理生成的class文件
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ConfigurableApplicationContext run = SpringApplication.run(SpringDemoApplication.class, args);
        System.out.println("author name:" + run.getBean(SpringDemoApplication.class).author);
    }

}
