package com.lilu.swordFingerOffer.Question_03;

/**
 * 《剑指offer》
 * 面试题3：题目一：在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Subject1 {
    public boolean duplicate(int[] numbers,int length,int[] duplication) {
        // 检查输入有效性
        if (length <= 0 || numbers == null) {
            return false;
        }
        for (int i = 0;i < length;i++) {
            if (numbers[i] < 0 || numbers[i] >= length) {
                return false;
            }
        }
        /* 遍历数组，如果i位置的数（称为数m）等于i，则i++
         * 否则将数m与数组中m位置的数进行比较，如果相等，则找到了重复的数
         * 否则将数m换到数组的m位置，重复以上比较过程
         */
        for (int i = 0;i < length;i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    // 重复的数
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }
}
