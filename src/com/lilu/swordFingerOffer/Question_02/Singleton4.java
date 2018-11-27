package com.lilu.swordFingerOffer.Question_02;

import java.io.Serializable;

/**
 * 线程安全的单例模式
 * 更好的解法：内部类
 * 同时实现序列化接口，可用性更强
 */
public class Singleton4 implements Serializable {
    private Singleton4(){}
    private static class SingletonHolder{
        private static final Singleton4 instance = new Singleton4();
    }
    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * 对象在反序列化时自动调用
     * @return
     */
    private Object readResolve() {
        return SingletonHolder.instance;
    }
}
