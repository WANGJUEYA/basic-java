//给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目： 
//
// 
// 0 <= i < j < k < nums.length 
// nums[i]、nums[j] 和 nums[k] 两两不同 。 
// 
// 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。 
// 
// 
//
// 返回满足上述条件三元组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,2,4,3]
//输出：3
//解释：下面列出的三元组均满足题目条件：
//- (0, 2, 4) 因为 4 != 2 != 3
//- (1, 2, 4) 因为 4 != 2 != 3
//- (2, 3, 4) 因为 2 != 4 != 3
//共计 3 个三元组，返回 3 。
//注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,1,1]
//输出：0
//解释：不存在满足条件的三元组，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 86 👎 0


package com.jue.java.learn.leetcode.editor.cn.NumberOfUnequalTripletsInArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 2475
 */
public class NumberOfUnequalTripletsInArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.unequalTriplets(new int[]{2, 5, 3, 3}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int unequalTriplets(int[] nums) {
        // 总数为 t, 该数占a; 其他个数为 t1,t2,t3
        // (T^2 - t1^2 - t2^2)/2
        Map<Integer, Integer> numberCount = new HashMap<>();
        int result = 0;
        int total = 0;
        int sub = 0; // t1^2 + t2^2 + t3^2
        for (int num : nums) {
            Integer count = numberCount.remove(num);
            if (count == null) {
                count = 0;
            }
            int newSub = sub - count * count;
            if (numberCount.size() >= 2) {
                result += ((total - count) * (total - count) - newSub) / 2;
            }
            total++;
            numberCount.put(num, count + 1);
            sub = newSub + (count + 1) * (count + 1);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
