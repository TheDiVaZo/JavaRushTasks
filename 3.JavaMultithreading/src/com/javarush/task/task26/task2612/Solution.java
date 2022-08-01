package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/

public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        boolean flag = true;
        try {
            lock.lockInterruptibly();
            if(lock.tryLock()) {
                actionIfLockIsFree();
            }
            else {
                flag = false;
                actionIfLockIsBusy();
            };
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(flag) lock.unlock();
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
