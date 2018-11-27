package com.lilu.swordFingerOffer.Question_02.test;

import com.lilu.swordFingerOffer.Question_02.Singleton3;

public class test3 extends Thread {
    @Override
    public void run() {
        System.out.println(Singleton3.getInstance().hashCode());
    }

    public static void main(String[] args) {
        test3[] test3s = new test3[10];
        for (int i = 0; i < test3s.length; i++) {
            test3s[i] = new test3();
        }
        for (int i = 0; i < test3s.length; i++) {
            test3s[i].start();
        }
    }
}
