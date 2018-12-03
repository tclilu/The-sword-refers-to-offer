package com.lilu.swordFingerOffer.Question_10;

/**
 * 《剑指offer》
 * 面试题10：
 * 扩展：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Question_10_03 {
    /**
     * 分析：
     * 第一步跳台阶有n种跳法：
     * 跳1级，剩下的台阶有JumpFloorII(n-1)种跳法
     * 跳2级，剩下的台阶有JumpFloorII(n-2)种跳法
     * ...
     * 跳n-1级，剩下的台阶有JumpFloorII(1)种跳法
     * 跳n级，剩下0级
     * 则总跳法JumpFloorII(n) = JumpFloorII(n-1) + JumpFloorII(n-2) + ... + JumpFloorII(1)
     * 而JumpFloorII(n-1) = JumpFloorII(n-2) + JumpFloorII(n-3) + ... + JumpFloorII(1)
     * 故JumpFloorII(n) = 2 * JumpFloorII(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target-1);
    }
}
