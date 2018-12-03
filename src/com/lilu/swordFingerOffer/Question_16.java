package com.lilu.swordFingerOffer;

/**
 * 面试题16：实现函数double Power(double base,int exponent),求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题
 */
public class Question_16 {
    public static double Power(double base,int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("input invalid");
        }
        // 0的0次方在数学上无意义
        if (base == 0 && exponent == 0) {
            return 0;
        }
        // exponent为负数时，求绝对值次方再求倒数
        int absExponent = exponent < 0 ? -exponent : exponent;
        double result = 1.0;
        for (int i = 1; i <= absExponent; i++) {
            result *= base;
        }
        return exponent < 0 ? 1.0 / result : result;
    }

    public static double Power2(double base,int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException("input invalid");
        }
        // 0的0次方无意义
        if (base == 0 && exponent == 0) {
            return 0;
        }
        int absExponent = exponent < 0 ? -exponent : exponent;
        double result = power2Core(base,absExponent);
        return exponent < 0 ? 1.0 / result : result;
    }

    private static double power2Core(double base, int absExponent) {
        if (absExponent == 0) {
            return 1;
        }
        if (absExponent == 1) {
            return base;
        }
        double result = power2Core(base,absExponent >> 1);
        result *= result;
        if ((absExponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Power(0,0));
        System.out.println(Power2(2,4));
    }
}
