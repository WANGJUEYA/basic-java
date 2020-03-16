package com.jue.java.learntest.leetcode.solution5356;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int[] flag = new int[rowSize + colSize]; // 存储每一行的最小 + 存储每一列的最大
        // 由于所有元素都不相等, 上面两个数组有相同元素即为幸运数
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                flag[i] = flag[i] == 0 ? matrix[i][j] : Math.min(flag[i], matrix[i][j]);
                flag[rowSize + j] = flag[rowSize + j] == 0 ? matrix[i][j] : Math.max(flag[rowSize + j], matrix[i][j]);
            }
        }
        Set<Integer> temp = new HashSet<>();
        for (int item : flag) {
            if (temp.contains(item)) {
                result.add(item);
            } else {
                temp.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println((new Solution()).luckyNumbers(array));
    }
}