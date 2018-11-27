package com.lilu.swordFingerOffer.Question_05;

public class Merge {
	public Integer[] insertSort(Integer[] arr1,Integer[] arr2) {
		if (arr1 == null && arr2 != null) {
			return arr2;
		}
		if (arr1 != null && arr2 == null) {
			return arr1;
		}
		if (arr1 == null && arr2 == null) {
			return null;
		}
		int len1 = 0;
		for (int i = 0;i < arr1.length;i++) {
			if (arr1[i] != null) {
				len1++;
			}
		}
		int p1 = len1 - 1;
		int p2 = arr2.length - 1;
		while (p1 >= 0 && p2 >= 0) {
			if (arr1[p1] >= arr2[p2]) {
				arr1[p1 + p2 + 1] = arr1[p1--];
			} else {
				arr1[p1 + p2 + 1] = arr2[p2--];
			}
			while (p1 < 0 && p2 >= 0) {
				arr1[p2] = arr2[p2--];
			}
		}
		return arr1;
	}

    public static void main(String[] args) {
        Merge m = new Merge();
//        Integer[] test = new Integer[10];
//		for (int i = 0; i < 5; i++) {
//			test[i] = i + 1;
//		}
//		for (int i = 0; i < test.length; i++) {
//			System.out.println(test[i]);
//		}
        Integer[] arr1 = {5,7,9,10,null,null,null,null,null,null};
		Integer[] arr2 = {1,2,3,8};
		Integer[] res = m.insertSort(arr1,arr2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}