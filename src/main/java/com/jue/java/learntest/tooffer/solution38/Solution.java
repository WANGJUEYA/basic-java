package com.jue.java.learntest.tooffer.solution38;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {5, 6, 1, 2, 3, 4};
        System.out.println(solution.minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        //非减数组默认首位最小
        int min = array[0];
        for (int i = 0, n = array.length - 1; i < n; i++) {
            if (array[i + 1] < array[i]) {
                min = array[i + 1];
                break;
            }
        }
        return min;
    }
}