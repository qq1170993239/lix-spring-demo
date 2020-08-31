package cn.lix.spring.demo.listeners;

import cn.lix.spring.demo.utils.LogUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class TestApplicationContextListner implements ApplicationListener<ApplicationContextEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        LogUtils.log().info("---ApplicationContextEvent---");
    }
}
