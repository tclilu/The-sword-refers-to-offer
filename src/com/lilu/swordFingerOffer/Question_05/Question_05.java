package com.lilu.swordFingerOffer.Question_05;

/**
 * 《剑指offer》
 * 面试题5：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如：输入“We are happy.”，则输出“We%20are%20happy.”。
 * 时间复杂度：O（n）
 */
public class Question_05 {
    /**
     * 分析：先遍历字符串计算字符串中空格的总数，由此计算出替换之后的字符串总长度
     * 每替换一个空格，长度增加2
     * 准备2个指针，p1，p2
     * p1指向原字符串尾部
     * p2指向新字符串尾部
     * 向前移动指针p1，如果不是空格则将字符复制到p2处
     * 遇见空格时，p2依次向前插入"0"，"2"，"%"，p1继续向前移动
     * 直至p1，p2到字符串首部
     * @param str
     * @return
     */
    public static String SpaceEncode(StringBuffer str) {
        if (str == null) {
            return "param error";
        }
        int len = str.length();
        int space_num = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                space_num++;
            }
        }
        // 每有一个空格，长度增加2
        int new_len = len + space_num * 2;
        // 设置stringBuffer长度
        str.setLength(new_len);
        // 指针p1指向原字符串尾部
        int p1 = len - 1;
        // 指针p2指向新字符串尾部
        int p2 = new_len - 1;
        while(p1 >= 0 && p2 >= 0 && p1 < p2) {
            if (str.charAt(p1) == ' ') {
                // replace方法：将该构建器从startIndex到endIndex-1的位置的字符替换为给定的字符串
                str.replace(p2 - 2,p2 + 1,"%20");
                p2 = p2 - 3;
            } else {
                str.setCharAt(p2--,str.charAt(p1));
            }
            p1--;
        }
        return str.toString();
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int len = str.length();
        int space_num = 0;
        for (int i = 0;i < len;i++) {
            if (str.charAt(i) == ' ') {
                space_num++;
            }
        }
        int new_len = len + space_num * 2;
        str.setLength(new_len);
        int p1 = len - 1;
        int p2 = new_len - 1;
        while(p1 >= 0 && p2 >= 0 && p1 < p2) {
            if (str.charAt(p1) == ' ') {
                str.replace(p2 - 2,p2 + 1,"%20");
                p2 = p2 - 3;
            } else {
                str.setCharAt(p2--,str.charAt(p1));
            }
            p1--;
        }
        return str.toString();
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer(" We are a happy.")));
    }
}
