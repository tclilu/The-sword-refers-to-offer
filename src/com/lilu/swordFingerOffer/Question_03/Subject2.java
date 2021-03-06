package com.lilu.swordFingerOffer.Question_03;

/**
 * 《剑指offer》
 * 面试题3：题目二：不修改数组找出重复的数字。
 * 在一个长度为n+1的数组里的所有数字都在1到n的范围内。
 * 所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字
 * 但不能修改输入的数组
 * 例如，如果输入长度为7的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3
 */
public class Subject2 {
	public static int getDuplication(int[] numbers,int length) {
		if (numbers == null || length <= 0) {
			return -1;
		}
		int left = 1;
		int right = length - 1;
		while(left <= right) {
			int middle = (left + right) / 2;
			int count = 0;
			for(int i = 0;i < length;i++) {
				if (numbers[i] >= left && numbers[i] <= middle) {
					count++;
				}
			}
			if (count > middle - left + 1) {
				right = middle;
			} else {
				left = middle;
			}
			if (left == right) {
				if (count > 1) {
					return left;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] numbers = {2,3,5,4,3,2,6,7};
		System.out.println(getDuplication(numbers,8));
	}
}