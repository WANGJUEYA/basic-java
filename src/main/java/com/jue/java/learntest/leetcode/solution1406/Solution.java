package com.jue.java.learntest.leetcode.solution1406;

class Solution {

    public static void main(String[] args) {
        System.out.println((new Solution()).stoneGameIII(new int[]{1, 2, 3, 7}));
    }

    boolean win = false;
    boolean tie = false;
    int[][] array = {{1, 1}, {1, 2}, {1, 3}, {2, 1}, {2, 2}, {2, 3}, {3, 1}, {3, 2}, {3, 3}};

    // 贪心算法是否可行?
    public String stoneGameIII(int[] stoneValue) {
        stoneGameIII(stoneValue, 0, 0, 0);
        if (win) {
            return "Alice";
        } else if (tie) {
            return "Tie";
        } else {
            return "Bob";
        }
    }

    // 强势暴力
    public void stoneGameIII(int[] stoneValue, int index, int aCount, int bCount) {
        if (index >= stoneValue.length) {
            if (aCount > bCount) {
                win = true;
            }
            if (aCount == bCount) {
                tie = true;
            }
            return;
        }
        int indexA, indexB, countA, countB, len = stoneValue.length;
        // 九种遍历过程 ??? 问题 遍历的结果对b 来说不是最优的
        for (int[] a : array) {
            for (indexA = 0, countA = aCount; indexA < a[0] && index + indexA < len; indexA++) {
                countA += stoneValue[index + indexA];
            }
            for (indexB = 0, countB = bCount; indexB < a[1] && index + a[0] + indexB < len; indexB++) {
                countB += stoneValue[index + a[0] + indexB];
            }
            stoneGameIII(stoneValue, index + a[0] + a[1], countA, countB);
        }
    }
}