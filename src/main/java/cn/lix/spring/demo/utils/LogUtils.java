package cn.lix.spring.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description  日志工具
 * @Author  lix <sclx1220@163.com>
 * @Date 2020/8/31
 */
public class LogUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogUtils.class);

    private static final Map<String, Logger> cacheMap = new HashMap<>(32);

    public static Logger log() {
        Logger logger;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            // 从栈中获取调用次静态方法的类
            String className = stackTrace[2].getClassName();
            logger = cacheMap.get(className);
            if (logger == null) {
                logger = LoggerFactory.getLogger(className);
                cacheMap.put(className, logger);
            }
        } catch (Exception e) {
            logger = LOGGER;
        }

        return logger;
    }

}
