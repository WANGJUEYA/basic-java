package com.jue.java.learntest.leetcode.solution0368;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] array1 = {4, 8, 10, 240};
        System.out.println((new Solution()).largestDivisibleSubset(array1));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len <= 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int[] count = new int[len];
        int maxCountIndex = 0;
        List<Integer> temp;
        for (int i = 0; i < len; i++) {
            temp = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && map.get(nums[j]).size() > temp.size()) {
                    temp = new ArrayList<>(map.get(nums[j]));
                }
            }
            temp.add(nums[i]);
            if ((count[i] = temp.size()) > count[maxCountIndex]) {
                maxCountIndex = i;
            }
            map.put(nums[i], temp);
        }
        return map.get(nums[maxCountIndex]);
    }
}