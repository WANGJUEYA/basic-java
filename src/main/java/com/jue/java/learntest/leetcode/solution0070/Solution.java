package com.jue.java.learntest.leetcode.solution0070;

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] array = new int[3];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[2] = array[0] + array[1];
            array[0] = array[1];
            array[1] = array[2];
        }
        return array[2];
    }
}