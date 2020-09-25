package cn.lix.spring.demo.config;

import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * @Description 自定义加载目录下的所有properties文件。配置内容可以使用@Value注入
 * @Author lix <sclx1220@163.com>
 * @Date 2020/9/24
 */
public class TestPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(this.getClass().getClassLoader());
        if (resource.getResource() == null) {
            throw new IllegalArgumentException("请配置value，多个配置路劲请用英文逗号隔开");
        }
        String description = resource.getResource().getDescription();
        String paths = description.substring(description.indexOf("[") + 1, description.indexOf("]"));
        String[] split = paths.split(",");
        Properties properties = new Properties();
        for (String path : split) {
            Resource[] resources = resolver.getResources(path.trim());
            for (Resource re : resources) {
                properties.load(re.getInputStream());
            }
        }
        PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(name, properties);
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
