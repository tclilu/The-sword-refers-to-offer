package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题4：在一个二维数组中，每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数
 */
public class Question_04 {
    /**
     * 分析：第一次选取数组右上角的数与要查找的数进行比较
     * 如果右上角的数大于要比较的数，则这一列的数都不符合（从上到下递增）
     * 如果右上角的数小于要比较的数，则这一行的数都不符合（从左到右递增）
     * 相等时，置flag为true
     * 比较到左下角时，比较结束。
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while(row <= array.length && col >= 0) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        Question_04 question_04 = new Question_04();
        System.out.println(question_04.Find(5,arr));
    }
}
