package cn.lix.spring.demo.listeners;

import cn.lix.spring.demo.utils.LogUtils;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class TestApplicationStartedEvent implements ApplicationListener<ApplicationStartedEvent> {

    //应用开启事件
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        LogUtils.log().info("-----ApplicationStartedEvent-----");
    }
}
