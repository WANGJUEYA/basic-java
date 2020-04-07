package com.jue.java.learntest.leetcode.solution0912;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString((new Solution()).sortArray(new int[]{5, 2, 3, 1})));
//        System.out.println(Arrays.toString((new Solution()).sortArray(new int[]{5, 1, 1, 2, 0, 0})));
        System.out.println(Arrays.toString((new Solution()).sortArray(new int[]{-1, 2, -8, -10})));
    }


    // 使用快速排序对数组进行排序
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortArray(int[] nums, int begin, int end) {
        int key = nums[begin];
        int low = begin, high = end;
        boolean first = true;
        while (low < high) {
            if (first) {
                if (nums[high] < key) {
                    nums[low++] = nums[high];
                    first = false;
                } else {
                    high--;
                }
            } else {
                if (nums[low] > key) {
                    nums[high--] = nums[low];
                    first = true;
                } else {
                    low++;
                }
            }
        }
        nums[low] = key;
        if (begin < low - 1) sortArray(nums, begin, low - 1);
        if (end > high + 1) sortArray(nums, high + 1, end);
    }
}