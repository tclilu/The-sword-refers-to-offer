package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题10：
 * 题目二：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Question_10_02 {
    /**
     * 分析：
     * 第一次上台阶有2种情况：
     * 1.上1级，剩下的台阶有JumpFloor(n-1)种跳法
     * 2.上2级，剩下的台阶有JumpFloor(n-2)种跳法
     * 故总跳法种数为JumpFloor(n-1)+JumpFloor(n-2)
     * 转换成斐波那锲问题
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 0) {
            throw new RuntimeException("target error");
        }
        int[] result = {1,2};
        if (target <= 2) {
            return result[target - 1];
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
