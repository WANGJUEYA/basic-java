package com.jue.java.learntest.leetcode.solution1405;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[][] array = new int[][]{{'a', a}, {'b', b}, {'c', c}};
        StringBuilder result = new StringBuilder();
        char c1 = ' ';
        char c2 = ' ';
        // 每次选择最大的一个字母填入
        do {
            Arrays.sort(array, Comparator.comparingInt(arr -> arr[1]));
            int index = 2;
            if (c1 == c2 && c1 == (char) array[index][0]) {
                if (array[1][1] > 0) {
                    index = 1;
                } else if (array[0][1] > 0) {
                    index = 0;
                } else {
                    return result.toString();
                }
            }
            c1 = c2;
            c2 = (char) array[index][0];
            result.append(c2);
            array[index][1]--;
        } while (array[0][1] > 0 || array[1][1] > 0 || array[2][1] > 0);
        return result.toString();
    }
}