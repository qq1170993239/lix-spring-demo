package cn.lix.spring.demo.conditions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Myconfig {

    /**
     * 通过指定该条件判断{@link MyConditionTest}是否需要创建该对象，
     * 执行类需要实现org.springframework.context.annotation.Condition接口.
     * 如{@link org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean}等注解的现实原理
     * @return
     */
    @Conditional(MyConditionTest.class)
    @Bean
    public String test(){
        return "{\"name\":\"zhangsan\",\"age\":\"24\"}";
    }

}


