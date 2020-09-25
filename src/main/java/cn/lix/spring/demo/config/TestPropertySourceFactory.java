package cn.lix.spring.demo.config;

import cn.lix.spring.demo.utils.LogUtils;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.io.InputStreamReader;
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
            LogUtils.log().error("未获取到org.springframework.context.annotation.PropertySource.value的配置信息");
            throw new IllegalArgumentException("请配置org.springframework.context.annotation.PropertySource.value");
        }

        String description = resource.getResource().getDescription();
        String path = description.substring(description.indexOf("[") + 1, description.indexOf("]"));

        Resource[] resources = resolver.getResources(path.trim());
        Properties properties = new Properties();
        for (Resource re : resources) {
            properties.load(new InputStreamReader(re.getInputStream(), resource.getEncoding() == null ? "utf-8" : resource.getEncoding()));
        }
        LogUtils.log().info("加载{}资源文件成功", path);
        name = name == null ? "defaultPropertySource@".concat(String.valueOf(properties.hashCode())) : name.concat("@").concat(String.valueOf(properties.hashCode()));
        return new PropertiesPropertySource(name, properties);
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
