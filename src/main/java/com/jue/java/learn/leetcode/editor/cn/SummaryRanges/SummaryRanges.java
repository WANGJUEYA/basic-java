//给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于
//nums 的数字 x 。
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//
// "a->b" ，如果 a != b
// "a" ，如果 a == b
//
//
//
//
// 示例 1：
//
//
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
//
//
// 示例 2：
//
//
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 20
// -2³¹ <= nums[i] <= 2³¹ - 1
// nums 中的所有值都 互不相同
// nums 按升序排列
//
//
// Related Topics 数组 👍 337 👎 0


package com.jue.java.learn.leetcode.editor.cn.SummaryRanges;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUE
 * @number 228
 */
public class SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7})); // "0->2","4->5","7"
        System.out.println(solution.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9})); // "0","2->4","6","8->9"
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        int begin = nums[0];
        // 合并连续数字
        for (int index = 1; index <= len; index++) {
            // 不等于处理上一个阶段; 最后一个数处理当前阶段
            if (index == len || nums[index] != nums[index - 1] + 1) {
                result.add(begin == nums[index - 1] ? String.valueOf(begin) : begin + "->" + nums[index - 1]);
                begin = index == len ? -1 : nums[index];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
