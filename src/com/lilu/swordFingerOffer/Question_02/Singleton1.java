package com.lilu.swordFingerOffer.Question_02;

/**
 * 单例模式（饥饿模式）
 * 缺点：该类在加载的时候就会直接new一个静态对象出来，在没有使用之前就已经初始化，
 * 如果对象很大，没有使用之前加载到内存中是很大的浪费
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1(){}
    public static Singleton1 getInstance() {
        return instance;
    }
}
