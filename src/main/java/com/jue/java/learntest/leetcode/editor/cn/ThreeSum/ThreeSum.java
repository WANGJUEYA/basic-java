//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package com.jue.java.learntest.leetcode.editor.cn.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 15
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {-1, 0, 1, 2, -1, -4};
        int[] array1 = {0, 0, 0, 0};
        int[] array2 = {-2, 0, 1, 1, 2};
        int[] array3 = {0, -4, -1, -4, -2, -3, 2};
        int[] array4 = {-2, -1, -1, 0, 1, 1, 2};
        System.out.println(solution.threeSum(array1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
