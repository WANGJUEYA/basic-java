//给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出
//这个重复的数。 
//
// 示例 1: 
//
// 输入: [1,3,4,2,2]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [3,1,3,4,2]
//输出: 3
// 
//
// 说明： 
//
// 
// 不能更改原数组（假设数组是只读的）。 
// 只能使用额外的 O(1) 的空间。 
// 时间复杂度小于 O(n2) 。 
// 数组中只有一个重复的数字，但它可能不止重复出现一次。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 815 👎 0


package com.jue.java.learn.leetcode.editor.cn.FindTheDuplicateNumber;

/**
 * @author JUE
 * @number 287
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDuplicate(int[] nums) {
        // 1. 不能改变原数组, 数组计数的方法失效(排序方式失效)
        // 2. 空间O(1), 另行存放方法失效(map方式失效)
        // 3. 时间复杂度O(n2)
        // 暴力比较法
        int len = nums.length;
        assert len > 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
