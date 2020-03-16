package com.jue.java.learntest.leetcode.solution0860;

class Solution {

    public static void main(String[] args) {
        System.out.println((new Solution()).lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }

    // 方法一: 先找大的零
    public boolean lemonadeChange(int[] bills) {
        int[] money = {0, 0}; // 只有五元十元能用于找零
        for (int b : bills) {
            if (b == 5 || b == 10) {
                money[b / 5 - 1]++;
            }
            int sub = b - 5;
            // 有十元的找零
            if (sub > 10 && money[1] > 0) {
                sub -= 10;
                money[1]--;
            }
            // 有足够的五元找零
            int need = sub / 5;
            if (money[0] < need) {
                return false;
            }
            money[0] -= need;
        }
        return true;
    }
}