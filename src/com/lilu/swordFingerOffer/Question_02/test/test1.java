package com.lilu.swordFingerOffer.Question_02.test;

import com.lilu.swordFingerOffer.Question_02.Singleton1;

public class test1 extends Thread {

    @Override
    public void run() {
        System.out.println(Singleton1.getInstance().hashCode());
    }

    public static void main(String[] args) {
        test1[] test1s = new test1[10];
        for (int i = 0; i < test1s.length; i++) {
            test1s[i] = new test1();
        }
        for (int i = 0; i < test1s.length; i++) {
            test1s[i].start();
        }
    }
}
