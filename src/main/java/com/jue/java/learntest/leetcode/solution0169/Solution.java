package com.jue.java.learntest.leetcode.solution0169;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxKey = 0;
        int maxValue = -1;
        for (int item : nums) {
            int tempValue = 1;
            if (map.containsKey(item)) {
                tempValue = map.get(item) + 1;
            }
            if (tempValue > nums.length / 2) {
                return item;
            }
            if (tempValue > maxValue) {
                maxKey = item;
                maxValue = tempValue;
            }
            map.put(item, tempValue);
        }
        return maxValue > nums.length / 2 ? maxKey : -1; // -1表示不存在多数元素
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).majorityElement(new int[]{3, 2, 3}));
    }
}