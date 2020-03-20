package com.jue.java.learntest.leetcode.solution_m_40_00;


import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        int len = arr.length;
        if (len <= 0 || k <= 0) {
            return result;
        }
        if (len <= k) {
            return arr;
        }
        Arrays.sort(arr);
        int index = 0;
        while (index < k) {
            result[index] = arr[index];
            index++;
        }
        return result;
    }
}