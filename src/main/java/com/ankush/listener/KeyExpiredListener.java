package com.ankush.listener;

import redis.clients.jedis.JedisPubSub;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ankush.a on 19/11/16.
 */
public class KeyExpiredListener extends JedisPubSub {
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);
    private static int count = 0;

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe "
                + pattern + " " + subscribedChannels);
    }

    @Override
    public void onMessage(String s, String s1) {

    }

    @Override
    public void onPMessage(String pattern, String channel, final String message) {

        if ("__keyevent@0__:expired".equals(channel)) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000L);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count++;
                    System.out.println("key : " + message + " is expired ...");
                    System.out.println("count = " + count);
                }
            });
        }

        //raise event
    }

    @Override
    public void onSubscribe(String s, int i) {

    }

    @Override
    public void onUnsubscribe(String s, int i) {

    }

    @Override
    public void onPUnsubscribe(String s, int i) {

    }

//add other Unimplemented methods


}
