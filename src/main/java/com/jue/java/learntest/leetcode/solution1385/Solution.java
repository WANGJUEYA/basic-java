package com.jue.java.learntest.leetcode.solution1385;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int item : arr1) {
            boolean flag = true;
            for (int value : arr2) {
                if (Math.abs(item - value) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}