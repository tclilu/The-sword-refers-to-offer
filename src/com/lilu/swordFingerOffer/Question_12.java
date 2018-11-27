package com.lilu.swordFingerOffer;

/**
 * 《剑指offer》
 * 面试题12：
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 */
public class Question_12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length < 1 || rows < 1 || cols < 1 || rows*cols != matrix.length || str == null || str.length < 1 || rows * cols < str.length) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        int pathLength = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix,rows,cols,str,i,j,visited,pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, char[] str, int row, int col, boolean[] visited, int pathLength) {
        boolean flag = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols + col] && matrix[row * cols + col] == str[pathLength]) {
            pathLength++;
            visited[row * cols + col] = true;
            if (str.length == pathLength) {
                return true;
            }
            flag = hasPathCore(matrix, rows, cols, str, row, col + 1, visited, pathLength) || // 右
                    hasPathCore(matrix, rows, cols, str, row, col - 1, visited, pathLength) || // 左
                    hasPathCore(matrix, rows, cols, str, row + 1, col, visited, pathLength) || // 下
                    hasPathCore(matrix, rows, cols, str, row - 1, col, visited, pathLength); // 上
            if (!flag) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'a','b','c','b','d'};
        Question_12 question_12 = new Question_12();
        boolean result = question_12.hasPath(matrix,3,4,str);
        System.out.println(result);
    }
}
