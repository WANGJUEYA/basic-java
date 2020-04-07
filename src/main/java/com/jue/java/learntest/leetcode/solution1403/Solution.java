package com.jue.java.learntest.leetcode.solution1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println((new Solution()).minSubsequence(new int[]{4, 3, 10, 9, 8}));
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        int total = 0;
        int count = 0;
        for (int n : nums) {
            total += n;
            count += n;
            result.add(0, n);
            int last = result.get(result.size() - 1);
            while (count - last > (total - count + last)) {
                result.remove(result.size() - 1); // FIXME
                count -= last;
                last = result.get(result.size() - 1);
            }
        }
        return result;
    }
}