package com.ankush.subscriber;

import com.ankush.listener.KeyExpiredListener;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by ankush.a on 19/11/16.
 */
public class Subscriber {

    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

        Jedis jedis = pool.getResource();
        jedis.psubscribe(new KeyExpiredListener(),
        //                "__keyevent@0__:expired");//
                 "__key*__:*");

    }

}
