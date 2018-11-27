package com.lilu.swordFingerOffer.Question_02.test;

import com.lilu.swordFingerOffer.Question_02.Singleton5;

public class test5 extends Thread {
    @Override
    public void run() {
        System.out.println(Singleton5.getInstance().hashCode());
    }

    public static void main(String[] args) {
        test5[] test5s = new test5[10];
        for (int i = 0; i < test5s.length; i++) {
            test5s[i] = new test5();
        }
        for (int i = 0; i < test5s.length; i++) {
            test5s[i].start();
        }
    }
}
