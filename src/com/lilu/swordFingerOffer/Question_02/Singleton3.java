package com.lilu.swordFingerOffer.Question_02;

/**
 * 懒汉模式
 * 使用双重检查锁提高并发度
 * 缺点：双重检查锁目前公认是一个Anti-pattern（反面模式），不推荐使用。
 * 原因：当一个线程A执行到类的第5行 if(null == instance) 时，如果instance为空，则加同步锁，
 * 继续往下执行实例化该类对象，但实例化是需要时间的，而对象的地址是立即创建的。
 * 此时如果线程B执行到该类的第5行，线程B判断instance的结果是不为空，直接返回了instance
 * 但是，这个instance并未被完整实例化。
 */
public class Singleton3 {
    private static volatile Singleton3 instance = null;
    private Singleton3(){}
    public static Singleton3 getInstance() {
        if (null == instance) {
            synchronized(Singleton3.class) {
                if (null == instance) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}