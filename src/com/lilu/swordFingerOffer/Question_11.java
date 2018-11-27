package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题11：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Question_11 {
    /**
     * 二分查找
     * 用2个指针left,right分别指向数组第一个元素和最后一个元素
     * 旋转数组的最小元素左边为一递增序列，右边也为一递增序列
     * 找到数组中间元素，如果大于右指针right指向的元素，则最小元素在中间元素右边
     * 如果小于右指针right指向的元素，则最小元素在中间元素左边
     * 缩小范围重复步骤
     * 最后left,right相邻为循环结束条件
     * right指针指向的元素为最小元素
     * 时间复杂度：O（log n）
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length - 1;
        if (array.length == 0) {
            return 0;
        }
        // 特殊情况，如果把排序数组前0个元素放到最后面，任然是旋转数组。最小值为left
        int minIndex = left;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                minIndex = right;
                break;
            }
            minIndex = (left + right) / 2;
            // 如果左边、中间、右边的数都相等，则无法使用二分查找
            // 例如[1,0,1,1,1] [1,1,1,0,1]
            // 只能用顺序查找
            if (array[left] == array[right] && array[minIndex] == array[right]) {
                return minInOrder(array,left,right);
            }
            // 中间的数大于左边的数，则最小的数在中间的数右边
            if (array[minIndex] >= array[left]) {
                left = minIndex;
            }
            // 中间的数大于右边的数，则最小的数在中间的数左边
            if (array[minIndex] <= array[right]) {
                right = minIndex;
            }
        }
        return array[minIndex];
    }

    private int minInOrder(int[] array, int left, int right) {
        int min = array[left];
        for (int i = left + 1; i <= right; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
