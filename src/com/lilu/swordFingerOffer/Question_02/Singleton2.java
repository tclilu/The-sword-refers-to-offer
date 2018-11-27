package com.lilu.swordFingerOffer.Question_02;

/**
 * 懒汉模式
 * 缺点：线程不安全。当A,B两个线程同时执行到if(null == instance)是
 * 都判断instance为空，2个线程同时实例化了Singleton2类。
 * 解决方案：给方法getInstance加同步锁，在Java中使用synchronized关键字修饰方法来加锁
 * 缺点：每次调用getInstance方法得到Singleton2类实例时都会试图加上同步锁
 * 而加锁属于耗时操作，一定程度上降低了程序的并发度
 */
public class Singleton2 {
    private static Singleton2 instance = null;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance(){
        if (null == instance) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton2();
        }
        return instance;
    }
}
