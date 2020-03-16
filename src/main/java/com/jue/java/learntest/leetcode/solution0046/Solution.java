package com.jue.java.learntest.leetcode.solution0046;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println((new Solution()).permute(array));
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 全排列的数量
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        result.add(temp);
        long count = 1;
        for (int x = 1; x < len; x++) { // 放入每个数据
            for (int y = 0; y < count; y++) { // 每个复制多少份
                List<Integer> base = result.get(y);
                for (int z = 0; z < x; z++) { // 克隆数组并且在对应位置新增
                    List<Integer> copy = new ArrayList<>(base);
                    copy.add(z, nums[x]);
                    result.add(copy);
                }
                base.add(nums[x]);
            }
            count *= (x + 1);
        }

        return result;
    }
}