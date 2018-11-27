package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》2.4.2节：对几万名员工年龄排序，要求时间复杂度O（n）,额外空间复杂度不超过O（n）
 */
public class Question_2_4_2 {
    public static void sortAge(int[] ages) {
        if (ages == null || ages.length <= 1) {
            return;
        }
        // 初始化一个大小为100的数组(int 默认为0)
        int[] countAge = new int[100];
        int len = ages.length;
        // 统计每个年龄出现的次数
        for (int i = 0; i < len; i++) {
            if (ages[i] < 0 || ages[i] >= 100) {
                throw new RuntimeException("age error");
            }
            countAge[ages[i]]++;
        }
        int index = 0;
        for (int i = 0; i < countAge.length; i++) {
            for (int j = 0; j < countAge[i]; j++) {
                ages[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] ages = {20,19,18,20,34,54,20,20,34,20};
        sortAge(ages);
        for (int i = 0; i < ages.length; i++) {
            System.out.println(ages[i]);
        }
    }
}
