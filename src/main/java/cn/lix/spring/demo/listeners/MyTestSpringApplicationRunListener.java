package cn.lix.spring.demo.listeners;

import cn.lix.spring.demo.utils.LogUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;

// 注册类：通过在resources\META-INF\spring.factories目录下定义spring.factories文件
public class MyTestSpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    private final SimpleApplicationEventMulticaster initialMulticaster;

    public MyTestSpringApplicationRunListener(SpringApplication application, String[] args) {
        this.application = application;
        this.args = args;
        this.initialMulticaster = new SimpleApplicationEventMulticaster();
    }

    @Override
    public void starting() {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        LogUtils.log().info("com.platform.mst.helper.listener.MyTestSpringApplicationRunListener.failed");
    }
}
