package com.jue.java.learntest.leetcode.solution0042;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    // 本例相关例题->接雨水2 可采用相同思路，一遍一遍遍历到等高
    // 但作为一维数组，优秀解法，先找到最高的柱子再向两边扩展[参考]
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 0) {
            return len;
        }
        int indexHighest = 0;
        for (int index = 1; index < len; index++) {
            if (height[index] > height[indexHighest]) {
                indexHighest = index;
            }
        }

        int count = 0;
        for (int index = 1; index < indexHighest; index++) {
            if (height[index] < height[index - 1]) {
                count += height[index - 1] - height[index];
                height[index] = height[index - 1];
            }
        }
        for (int index = len - 2; index > indexHighest; index--) {
            if (height[index] < height[index + 1]) {
                count += height[index + 1] - height[index];
                height[index] = height[index + 1];
            }
        }
        return count;
    }
}