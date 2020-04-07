package com.jue.java.learntest.leetcode.solution0877;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).stoneGame(new int[]{7, 8, 8, 10}));
        System.out.println((new Solution()).stoneGame(new int[]{3, 2, 10, 4}));
    }


    public boolean stoneGame(int[] piles) {
        return true;
    }

    // 简单的贪心算法并不可取 return true;
    public boolean stoneGame_NeedFix(int[] piles) {
        int i = -1, j = piles.length, len = piles.length;
        int A = 0, B = 0, temp;
        boolean flag = true;
        while (i < len - 1 && j > 0) {
            temp = piles[i + 1] > piles[j - 1] ? piles[++i] : piles[--j];
            if (flag) {
                A += temp;
            } else {
                B += temp;
            }
            flag = !flag;
        }
        return A > B;
    }
}