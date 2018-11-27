package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题14：
 * 给你一根长度为n的绳子，请把绳子剪成m段 (m和n都是整数，n>1并且m>1)
 * 每段绳子的长度记为k[0],k[1],…,k[m]。请问k[0]k[1]…*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class Question_14 {
    // 有两种不同的方法解决这个问题
    // 1、动态规划：时间复杂度O（n^2）;空间复杂度：O（n）
    // 2、贪心算法：时间复杂度O（1）;空间复杂度O（1）

    /**
     * 动态规划法
     * @param length
     * @return
     */
    public int maxProductAfterCuttingSolution1(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        // 初始1,2,3代表绳子长度，为了计算乘积
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                    products[i] = max;
                }
            }
        }
        return products[length];
    }

    /**
     * 贪心算法
     * @param length
     * @return
     */
    public int maxProductAfterCuttingSolution2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        // 尽可能多的剪出长度为3的绳子
        int timesOf3 = length / 3;
        // 当绳子最后剩下的长度为4（剩下长度为1）的时候，不能再剪去长度为3的绳子长度
        if ((length - timesOf3 * 3) == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)(Math.pow(2,timesOf2) * Math.pow(3,timesOf3));
    }

    public static void main(String[] args) {
        Question_14 question_14 = new Question_14();
        System.out.println(question_14.maxProductAfterCuttingSolution1(8));
    }
}
