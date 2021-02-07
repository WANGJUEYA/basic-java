package com.jue.java.learn.tooffer.solution18;

public class Solution {

    public static void main(String[] args) {
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        char[] str2 = {'a', 'b', 'c', 'b'};
        System.out.println((new Solution()).hasPath(matrix, 3, 4, str));
        System.out.println((new Solution()).hasPath(matrix, 3, 4, str2));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix.length != rows * cols) {
            return false;
        }
        if (str.length <= 0) {
            return true;
        }
        int len = matrix.length;
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (matrix[i] == str[0]) {
                flag[i] = true;
                if (hasPath(matrix, flag, cols, i, str, 0)) {
                    return true;
                }
                flag[i] = false;
            }
        }
        return false;
    }

    /**
     * 上->(this-cols)>0
     * 下->(this+cols)<len
     * 左->(this-1)>0 && (this-1)/cols == this/cols
     * 右->(this+1)<len && (this+1)/cols == this/cols
     */
    private boolean hasPath(char[] matrix, boolean[] flag, int cols, int index, char[] str, int indexSub) {
        indexSub++;
        if (indexSub >= str.length) {
            return true;
        }
        int next = index - cols;
        //上方有路
        if (next >= 0 && !flag[next] && matrix[next] == str[indexSub]) {
            flag[next] = true;
            if (hasPath(matrix, flag, cols, next, str, indexSub)) {
                return true;
            }
            flag[next] = false;
        }
        next = index + cols;
        //下方有路
        if (next < matrix.length && !flag[next] && matrix[next] == str[indexSub]) {
            flag[next] = true;
            if (hasPath(matrix, flag, cols, next, str, indexSub)) {
                return true;
            }
            flag[next] = false;
        }
        next = index - 1;
        //左方有路
        if (next >= 0 && (next / cols) == (index / cols) && !flag[next] && matrix[next] == str[indexSub]) {
            flag[next] = true;
            if (hasPath(matrix, flag, cols, next, str, indexSub)) {
                return true;
            }
            flag[next] = false;
        }
        //右方右路
        next = index + 1;
        if (next < matrix.length && (next / cols) == (index / cols) && !flag[next] && matrix[next] == str[indexSub]) {
            flag[next] = true;
            if (hasPath(matrix, flag, cols, next, str, indexSub)) {
                return true;
            }
            flag[next] = false;
        }
        return false;
    }
}

class SolutionPerfect {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    //judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1)
            return true;
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }
}