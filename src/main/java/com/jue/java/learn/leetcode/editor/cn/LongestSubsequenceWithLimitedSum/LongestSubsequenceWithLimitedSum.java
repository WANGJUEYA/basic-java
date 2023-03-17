//给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。 
//
// 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度
// 。 
//
// 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,2,1], queries = [3,10,21]
//输出：[2,3,4]
//解释：queries 对应的 answer 如下：
//- 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
//- 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
//- 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,4,5], queries = [1]
//输出：[0]
//解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 1000 
// 1 <= nums[i], queries[i] <= 10⁶ 
// 
//
// Related Topics 贪心 数组 二分查找 前缀和 排序 👍 85 👎 0


package com.jue.java.learn.leetcode.editor.cn.LongestSubsequenceWithLimitedSum;

import java.util.Arrays;

/**
 * @author JUE
 * @number 2389
 */
public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
        System.out.println(Arrays.toString(solution.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})));
        System.out.println(Arrays.toString(solution.answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450})));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        // 前缀和?? 前缀和小于指定值的最大index
        int len = nums.length;
        int[] pre = new int[len + 1];
        for (int index = 0; index < len; index++) {
            pre[index + 1] = pre[index] + nums[index];
        }
        for (int index = 0, c = queries.length; index < c; index++) {
            // 二分查找小于指定数的最大i
            int l = 0, h = len;
            int value = queries[index];
            while (l < h) {
                int mid = (l + h + 1) / 2;
                if (pre[mid] > value) {
                    h = mid - 1;
                } else {
                    if (l == mid || (pre[mid] == value)) {
                        l = mid;
                        break;
                    }
                    l = mid;
                }
            }
            queries[index] = l;
        }
        return queries;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
