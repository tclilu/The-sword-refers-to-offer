package com.lilu.swordFingerOffer.Question_10;

/**
 * 《剑指offer》
 * 面试题10：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
public class Question_10 {
    /**
     * 效率很低的解法，挑剔的面试官不会喜欢
     * 递归的过程中存在重复计算
     * 例如：计算f(3)需计算f(2)+f(1)
     * 计算f(4)需计算f(3)+f(2)
     * 此处f(2)就重复计算了
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 实用解法
     * 时间复杂度O（n）
     * @param n
     * @return
     */
    public int Fibonacci_2(int n) {
        int[] result = {0,1};
        if (n < 2) {
            return result[n];
        }
        int num1 = 0;
        int num2 = 1;
        int fibonacci_sum = 0;
        for (int i = 2; i <= n; i++) {
            fibonacci_sum = num1 + num2;
            num1 = num2;
            num2 = fibonacci_sum;
        }
        return fibonacci_sum;
    }

    // 时间复杂度为O（logn）但不够实用的解法，利用数学公式，矩阵...
}
