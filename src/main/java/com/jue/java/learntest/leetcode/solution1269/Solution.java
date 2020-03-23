package com.jue.java.learntest.leetcode.solution1269;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).numWays(3, 2));
        System.out.println((new Solution()).numWays(47, 38));
        System.out.println((new Solution()).numWays(438, 3159));
    }

    public int numWays(int steps, int arrLen) {
        int len = Math.min(steps + 1, arrLen);
        int[] base = new int[len];
        int[] newest;
        base[0] = 1;
        base[1] = 1;
        for (int i = 1; i < steps - 1; i++) {
            newest = new int[len];
            for (int j = 0; j < len; j++) {
                long temp = base[j];
                if (j - 1 >= 0) {
                    temp += base[j - 1];
                }
                if (j + 1 < len) {
                    temp += base[j + 1];
                }
                newest[j] = (int) (temp % (1E9 + 7));
            }
            base = newest;
        }
        return (int) ((base[0] + base[1]) % (1E9 + 7));
    }
}