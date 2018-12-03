package com.lilu.swordFingerOffer;

/**
 * 面试题15相关题目：
 * 1、用一条语句判断一个整数是不是2的整数次方。一个整数如果是2的整数次方，那么它的二进制表示中有且仅有一位是1
 * 而其他所有位都是0。根据前面的分析，把这个整数减去1之后再和它自己做与运算，这个整数中唯一的1就会变为0。
 *
 * 2、输入两个整数m和n,计算需要改变m的二进制表示中的多少位才能得到n。
 * 比如10的二进制表示为1010,13的二进制表示为1101，需要改变1010中的3位才能得到1101。
 * 我们可以分为两步解决这个问题：第一步求这两个数的异或；第二步统计异或结果中1的位数。
 */
public class Question_15_01 {
    public static boolean judgeIntegerIsPowerOfTwo(int n) {
        return ((n - 1) & n) == 0;
    }

    public static int changeMToN(int m,int n) {
        int count = 0;
        int temp = m ^ n;
        while (temp != 0) {
            count++;
            temp = (temp - 1) & temp;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(judgeIntegerIsPowerOfTwo(2));
        System.out.println(changeMToN(10,13));
    }
}
