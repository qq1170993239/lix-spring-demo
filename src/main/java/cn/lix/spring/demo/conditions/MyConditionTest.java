package cn.lix.spring.demo.conditions;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * @Description  {@link org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean}
 * @Author  lix <sclx1220@163.com>
 * @Date 2020/7/18
 */
public class MyConditionTest implements Condition {

    // 返回true会被注入spring，false不会
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }

}
