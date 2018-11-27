package com.lilu.swordFingerOffer.Question_02.test;

import com.lilu.swordFingerOffer.Question_02.Singleton2;

public class test2 extends Thread {
    @Override
    public void run() {
        System.out.println(Singleton2.getInstance().hashCode());
    }

    public static void main(String[] args) {
        test2[] test2s = new test2[10];
        for (int i = 0; i < test2s.length; i++) {
            test2s[i] = new test2();
        }
        for (int i = 0; i < test2s.length; i++) {
            test2s[i].start();
        }
    }
}
