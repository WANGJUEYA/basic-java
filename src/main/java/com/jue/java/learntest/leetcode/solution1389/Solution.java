package com.jue.java.learntest.leetcode.solution1389;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0, len = index.length; i < len; i++) {
            result.add(index[i], nums[i]);
        }
        int[] array = new int[result.size()];
        int i = 0;
        for (Integer integer : result) {
            array[i++] = integer;
        }
        return array;
    }
}