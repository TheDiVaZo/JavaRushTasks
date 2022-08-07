package com.javarush.task.task28.task2802;

import java.util.*;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        private static volatile AtomicInteger groupNumber = new AtomicInteger();

        private static Map<String, Integer> groups = Collections.synchronizedMap(new HashMap<>());

        static {
            groupNumber.set(0);
        }

        public volatile AtomicInteger countThread = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            String threadGroupName = Thread.currentThread().getThreadGroup().getName();
            if(!groups.containsKey(threadGroupName)) groups.put(threadGroupName, groupNumber.incrementAndGet());
            Thread thread = new Thread(r);
            thread.setDaemon(false);
            thread.setPriority(5);
            thread.setName(threadGroupName + "-pool-" + groups.get(threadGroupName) + "-thread-" +countThread.incrementAndGet());
            return thread;
        }
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }
}
