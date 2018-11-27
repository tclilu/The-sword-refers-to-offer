package com.lilu.swordFingerOffer.Question_02;

/**
 * 利用静态代码块在类加载之前执行且只执行一遍来实现单例模式（饥饿模式）
 */
public class Singleton5 {
    private static Singleton5 instance = null;
    static {
        instance = new Singleton5();
    }
    private Singleton5(){}
    public static Singleton5 getInstance() {
        return instance;
    }
}
