package cn.lix.spring.demo.others.redis;

import cn.lix.spring.demo.utils.LogUtils;
import redis.clients.jedis.Jedis;

public class JedisTest {

    public static void main(String[] args) {
        // 获取连接
        Jedis jedis = new Jedis("127.0.0.1", 16379);
        jedis.auth("lixiang88");
        // 执行命令
        jedis.set("my-redis-test", "my-redis-test");
        // 验证值
        LogUtils.log().info(jedis.get("my-redis-test"));
        // 关闭连接
        jedis.close();
    }
}
