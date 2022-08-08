//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 402 👎 0


package com.jue.java.learn.leetcode.editor.cn.ContainsDuplicateIi;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 219
 */
public class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); // true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println(solution.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
        System.out.println(solution.containsNearbyDuplicate(new int[]{99, 99}, 2)); // true
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> numberOfLatestIndex = new HashMap<>(len);
        for (int index = 0; index < len; index++) {
            if (numberOfLatestIndex.containsKey(nums[index])) {
                if (Math.abs(index - numberOfLatestIndex.get(nums[index])) <= k) {
                    return true;
                }
            }
            numberOfLatestIndex.put(nums[index], index);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class SolutionTimeout {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 使用滑动窗口处理: 时间复杂度 n * 2k, 空间复杂度 n
        // hash表: 时间复杂度 n++, 空间复杂度 2n
        for (int index = 0, len = nums.length; index < len; index++) {
            for (int newIndex = index - k; newIndex <= index + k; newIndex++) {
                if (newIndex != index && newIndex >= 0 && newIndex < len && nums[index] == nums[newIndex]) {
                    return true;
                }
            }
        }
        return false;
    }
}
