package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题13：
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Question_13 {
    public int movingCount(int threshold,int rows,int cols) {
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold,rows,cols,0,0,visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && check(threshold,row,col)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold,rows,cols,row + 1,col,visited) + // 下
                    movingCountCore(threshold,rows,cols,row - 1,col,visited) + // 上
                    movingCountCore(threshold,rows,cols,row,col + 1,visited) + // 右
                    movingCountCore(threshold,rows,cols,row,col - 1,visited); // 左
        }
        return count;
    }

    private boolean check(int threshold, int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row%10;
            row = row/10;
        }
        while (col != 0) {
            sum += col%10;
            col = col/10;
        }
        if (sum > threshold) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Question_13 question_13 = new Question_13();
        System.out.println(question_13.movingCount(18,40,40));
    }
}