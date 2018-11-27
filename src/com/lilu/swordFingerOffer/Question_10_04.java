package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题10：
 * 相关题目
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Question_10_04 {
    /**
     * 分析：
     * 第一个小矩形有2种覆盖方法：
     * 1.竖着放：则剩余有 RectCover(n - 1)种方法
     * 2.横着放，则需要有另一个小矩形横着放在第一个矩形下方，剩余有 RectCover(n - 2)种方法
     * 总共有 RectCover(n - 1) + RectCover(n - 2)种方法
     * 转换成斐波那楔问题
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int num1 = 1;
        int num2 = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        return sum;
    }
}
