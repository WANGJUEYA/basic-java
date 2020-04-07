package com.jue.java.learntest.leetcode.solution1012;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).numDupDigitsAtMostN(12));
        System.out.println((new Solution()).numDupDigitsAtMostN(11));
        System.out.println((new Solution()).numDupDigitsAtMostN(20));
        System.out.println((new Solution()).numDupDigitsAtMostN(100));
        System.out.println((new Solution()).numDupDigitsAtMostN(1000));
        System.out.println((new Solution()).numDupDigitsAtMostN(120));
        System.out.println((new Solution()).numDupDigitsAtMostN(110));
    }

    // 推荐思路 数位DP?
    public int numDupDigitsAtMostN(int N) {
        if (N < 10) {
            return 0;
        }

        // 1. 找到所有不重复的数字
        int pos = (int) Math.log10(N);
        int[] bound = new int[pos + 1];
        for (int temp = N, index = pos; index >= 0; index--, temp /= 10) {
            bound[index] = temp % 10;
        }

        int sum = 0;
        int bit = 0;
        int count = 1;
        boolean[] temp = new boolean[10];
        boolean self = true;
        while (bit <= pos) {
            if (bit == 0) {
                count *= 9;
            } else {
                count *= 10 - bit;
            }
            if (bit < pos) {
                sum += count;
            }
            if (bit == 0) {
                sum += (bound[bit] - 1) * A(pos - bit, 9 - bit);
            } else if (self) {
                int index = -1;
                int prefix = 0;
                while (++index < bound[bit]) {
                    if (!temp[index]) {
                        prefix++;
                    }
                }
                sum += prefix * A(pos - bit, 9 - bit);
            }
            if (temp[bound[bit]]) {
                self = false;
            }
            temp[bound[bit]] = true;
            bit++;
        }
        if (self) {
            sum++;
        }
        return N - sum;
    }

    private int A(int a, int b) {
        if (a <= 0) {
            return 1;
        } else if (a == 1) {
            return b;
        } else {
            return b * A(a - 1, b - 1);
        }
    }
}