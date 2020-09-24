package cn.lix.spring.demo.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @Description  自定义加载目录下的所有properties文件。配置内容可以使用@Value注入
 * @Author  lix <sclx1220@163.com>
 * @Date 2020/9/24
 */
public class TestPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(this.getClass().getClassLoader());
        Resource[] resources = resolver.getResources("classpath:/**/*.properties");
        Properties properties = new Properties();
        for (Resource resource1 : resources) {
            properties.load(resource1.getInputStream());
        }
        PropertiesPropertySource propertiesPropertySource  = new PropertiesPropertySource("testPropertySource", properties);
        return propertiesPropertySource;
    }


//    public static void main(String[] args) throws IOException {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(TestPropertySourceFactory.class.getClassLoader());
//        Resource[] resources = resolver.getResources("classpath:/**/*.yml");
//        YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
//        for (Resource resource : resources) {
//            List<PropertySource<?>> load = yamlPropertySourceLoader.load(resource.getFilename(), resource);
//            System.out.println(load.toString());
//        }
//    }
}
