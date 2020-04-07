package com.jue.java.learntest.leetcode.solution1111;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new Solution()).maxDepthAfterSplit("(()())")));
        System.out.println(Arrays.toString((new Solution()).maxDepthAfterSplit("()(())()")));
        System.out.println(Arrays.toString((new Solution()).maxDepthAfterSplit("()((()))()")));
    }

    public int[] maxDepthAfterSplit_Perfect(String seq) {
        int len = seq.length();
        if (len <= 0) {
            return new int[0];
        }

        int[] result = new int[len];
        int stack = 0;
        // 按照奇偶性分配
        for (int index = 0; index < len; index++) {
            if ('(' == seq.charAt(index)) {
                stack++;
                result[index] = stack % 2;
            } else {
                result[index] = stack % 2;
                stack--;
            }
        }
        return result;
    }

    public int[] maxDepthAfterSplit(String seq) {
        int len = seq.length();
        if (len <= 0) {
            return new int[0];
        }

        int[] result = new int[len];
        int maxDeep = 0;
        int stack = 0;
        for (int index = 0; index < len; index++) {
            if ('(' == seq.charAt(index)) {
                maxDeep = Math.max(maxDeep, result[index] = ++stack);
            } else {
                result[index] = stack--;
            }
        }
        maxDeep = maxDeep / 2;
        for (int index = 0; index < len; index++) {
            if (result[index] > maxDeep) {
                result[index] = 1;
            } else {
                result[index] = 0;
            }
        }
        return result;
    }
}