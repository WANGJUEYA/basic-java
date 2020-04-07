package com.jue.java.learntest.leetcode.solution_m_63_00;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i : prices) {
            max = Math.max(max, i - min);
            min = Math.min(min, i);
        }
        return max;
    }
}