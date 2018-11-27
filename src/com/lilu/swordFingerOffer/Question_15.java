package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题15：
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Question_15 {
    public static int getNumOf1InBinary(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Question_15.getNumOf1InBinary(0));
    }
}
