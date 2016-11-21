package com.ankush.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ankush.a on 19/11/16.
 */
public class TestJedis {
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        final JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

//        Jedis jedis = pool.getResource();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Jedis jedis = pool.getResource();
                for (int i = 0; i <= 100; i++) {
                    jedis.set("i" + (i + 1), "i");
                    jedis.expire("i" + (i + 1), 5);
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Jedis jedis = pool.getResource();
                for (int j = 0; j <= 100; j++) {
                    jedis.set("j" + (j + 1), "i");
                    jedis.expire("j" + (j + 1), 5);
                }
            }
        });


    }

}
