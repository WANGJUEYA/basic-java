//给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10^4 
// 1 <= nums[i] <= 10^4 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 288 👎 0


package com.jue.java.learn.leetcode.editor.cn.GreatestSumDivisibleByThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JUE
 * @number 1262
 */
public class GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{3, 1, 2}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        List<Integer> mod1 = new ArrayList<>();
        List<Integer> mod2 = new ArrayList<>();
        for (int n : nums) {
            int mod = n % 3;
            if (mod == 1) {
                mod1.add(n);
            } else if (mod == 2) {
                mod2.add(n);
            }
            result += n;
        }
        int mod = result % 3;
        if (mod == 1) {
            int sub1 = mod1.size() < 1 ? Integer.MAX_VALUE : mod1.get(0);
            int sub2 = mod2.size() < 2 ? Integer.MAX_VALUE : (mod2.get(0) + mod2.get(1));
            return result - Math.min(sub1, sub2);
        } else if (mod == 2) {
            int sub1 = mod1.size() < 2 ? Integer.MAX_VALUE : (mod1.get(0) + mod1.get(1));
            int sub2 = mod2.size() < 1 ? Integer.MAX_VALUE : mod2.get(0);
            return result - Math.min(sub1, sub2);
        } else {
            return result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
