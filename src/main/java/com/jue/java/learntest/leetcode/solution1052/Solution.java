package com.jue.java.learntest.leetcode.solution1052;

class Solution {
    public static void main(String[] args) {
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println((new Solution()).maxSatisfied(customers, grumpy, 3));
    }

    // 可以采用滑动窗口的方式
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int sum = 0;
        int max = 0;
        for (int index = 0; index < len; index++) {
            // 正常营业
            if (grumpy[index] == 0) {
                sum += customers[index];
            } else {
                int tempMax = customers[index];
                for (int j = index + 1; j < (index + X) && j < len; j++) {
                    if (grumpy[j] == 1) {
                        tempMax += customers[j];
                    }
                }
                max = Math.max(max, tempMax);
            }
        }
        return sum + max;
    }
}