package com.lilu.swordFingerOffer;

/**
 * 面试题17：打印从1到最大的n位数
 * 题目：输入数字n,按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999
 */
public class Question_17 {
    /**
     * 使用字符串表示大数
     * @param n
     */
    public static void print1ToMaxOfNDigits1(int n) {
        if (n <= 0) {
            return;
        }
        // 初始化字符串
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append(0);
        }
        // 没有超过最大的数时打印
        while (!increment(stringBuffer)) {
            printNumber(stringBuffer);
        }
    }

    /**
     * 判断是否到达最大的n位数
     * 时间复杂度：O（1）
     * @param number
     * @return
     */
    private static boolean increment(StringBuffer number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length();
        for(int i = nLength - 1; i >= 0; i--){
            int nSum = number.charAt(i) - '0' + nTakeOver;
            if( i == nLength - 1){
                nSum++;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;

                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    number.setCharAt(i, (char) ('0' + nSum));
                }

            }else{
                number.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印开头不为0的数字
     * @param number
     */
    private static void printNumber(StringBuffer number) {
        boolean isBeginning0 = true;
        for(int i = 0; i < number.length(); i++){
            if(isBeginning0 && number.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(number.charAt(i));
            }
        }
        System.out.println();
    }

    /**
     * 如果在数字前面补0，则n位所有十进制数其实就是n个从0到9的全排列
     * 把数字的每一位从0到9排列一遍，就得到了全部的十进制数。
     * 打印时排在前面的0不打印出来
     * @param n
     */
    public static void print1ToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            stringBuffer.append('0');
        }
        for (int i = 0; i < 10; i++) {
            stringBuffer.setCharAt(0,(char)(i +'0'));
            print1ToMaxOfNDigits2Core(stringBuffer,n,0);
        }
    }

    /**
     * 核心递归
     * @param number
     * @param n
     * @param index
     */
    private static void print1ToMaxOfNDigits2Core(StringBuffer number, int n, int index) {
        // 递归结束的条件：已经设置了最后一位数
        if (index == n - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number.setCharAt(index + 1,(char)(i + '0'));
            print1ToMaxOfNDigits2Core(number,n,index + 1);
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits1(2);
        /*print1ToMaxOfNDigits2(6666);*/
        /*char test = '0' + 0;
        System.out.println(test);*/
    }
}
