package com.jue.java.learntest.leetcode.solution0015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        int[] array1 = {0, 0, 0, 0};
        int[] array2 = {-2, 0, 1, 1, 2};
        int[] array3 = {0, -4, -1, -4, -2, -3, 2};
        int[] array4 = {-2, -1, -1, 0, 1, 1, 2};
        System.out.println((new Solution()).threeSum(array1));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (len <= 0 || nums[0] * nums[len - 1] > 0) {
            return result;
        }
        int beginX = nums[0];
        for (int x = 0; x < len - 2; x++) {
            if (x != 0 && nums[x] == beginX) {
                continue;
            }
            beginX = nums[x];
            int y = x + 1, z = len - 1;
            int beginY = nums[y], beginZ = nums[z];
            while (y < z) {
                if (nums[y] + nums[z] == -nums[x]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[x]);
                    temp.add(nums[y]);
                    temp.add(nums[z]);
                    result.add(temp);
                }
                if (nums[y] + nums[z] >= -nums[x]) {
                    do {
                        z--;
                    } while (z > x + 1 && beginZ == nums[z]);
                    beginZ = nums[z];
                } else {
                    do {
                        y++;
                    } while (y < z && beginY == nums[y]);
                    beginY = nums[y];
                }
            }
        }
        return result;
    }
}