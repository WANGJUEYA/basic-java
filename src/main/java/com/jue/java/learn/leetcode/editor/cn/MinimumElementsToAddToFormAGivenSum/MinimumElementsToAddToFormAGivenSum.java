//给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
//
// 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
//
//
// 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,-1,1], limit = 3, goal = -4
//输出：2
//解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
//
//
// 示例 2：
//
//
//输入：nums = [1,-10,9,1], limit = 100, goal = 0
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= limit <= 10⁶
// -limit <= nums[i] <= limit
// -10⁹ <= goal <= 10⁹
//
//
// Related Topics 贪心 数组 👍 17 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumElementsToAddToFormAGivenSum;

import java.math.BigInteger;

/**
 * @author JUE
 * @number 1785
 */
public class MinimumElementsToAddToFormAGivenSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minElements(new int[]{1, -1, 1}, 3, -4)); // 2
        System.out.println(solution.minElements(new int[]{1, -10, 9, 1}, 100, 0)); // 1
        System.out.println(solution.minElements(new int[]{-1, 0, 1, 1, 1}, 1, 771843707)); // 771843705
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        // 每个数字去计算应该加多少, 最后差值应该是0, 中途只计算差值与limit的差距
        int sub = -goal;
        int count = 0;
        for (int n : nums) {
            sub += n;
            int subAbs = Math.abs(sub);
            if (subAbs >= limit) {
                int flag = sub > 0 ? 1 : -1;
                sub = subAbs % limit * flag;
                count = count + ((subAbs / limit) * flag);
            }
        }
        // 如果同方向,继续追加
        if (sub != 0 && sub * count >= 0) {
            if (sub > 0) {
                count++;
            } else {
                count--;
            }
        }
        return Math.abs(count);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Solution_BigInteger {
    public int minElements(int[] nums, int limit, int goal) {
        BigInteger sum = new BigInteger("0");
        for (int n : nums) {
            sum = sum.add(new BigInteger(String.valueOf(n)));
        }
        BigInteger sub = sum.subtract(new BigInteger(String.valueOf(goal))).abs();
        // 取上整
        BigInteger limitBig = new BigInteger(String.valueOf(limit));
        int result = sub.divide(limitBig).intValue();
        return result + (sub.mod(limitBig).intValue() > 0 ? 1 : 0);
    }
}

class Solution_BigData {
    // 注意: 官解和改成long不会溢出
    public int minElements(int[] nums, int limit, int goal) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int sub = Math.abs(goal - sum);
        // 取上整
        return sub / limit + (sub % limit > 0 ? 1 : 0);
    }
}
