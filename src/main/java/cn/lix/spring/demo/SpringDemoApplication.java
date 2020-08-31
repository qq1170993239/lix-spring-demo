package cn.lix.spring.demo;

import cn.lix.spring.demo.imports.TestImportSelectors;
import cn.lix.spring.demo.utils.LogUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(TestImportSelectors.class)
@SpringBootApplication
@MapperScan("cn.lix.spring.demo.dao")
public class SpringDemoApplication {

    public static void main(String[] args) {
        // 保留JDK动态代理生成的class文件
        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}
