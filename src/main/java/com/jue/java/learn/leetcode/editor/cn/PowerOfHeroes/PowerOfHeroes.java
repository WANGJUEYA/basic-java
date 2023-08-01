//给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为： 
//
// 
// i0 ，i1 ，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])² 
//* min(nums[i0],nums[i1] ... nums[ik]) 。 
// 
//
// 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7 取余。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4]
//输出：141
//解释：
//第 1 组：[2] 的力量为 2² * 2 = 8 。
//第 2 组：[1] 的力量为 1² * 1 = 1 。
//第 3 组：[4] 的力量为 4² * 4 = 64 。
//第 4 组：[2,1] 的力量为 2² * 1 = 4 。
//第 5 组：[2,4] 的力量为 4² * 2 = 32 。
//第 6 组：[1,4] 的力量为 4² * 1 = 16 。
//第​ ​​​​​​7 组：[2,1,4] 的力量为 4²​​​​​​​ * 1 = 16 。
//所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1]
//输出：7
//解释：总共有 7 个英雄组，每一组的力量都是 1 。所以所有英雄组的力量之和为 7 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 数学 前缀和 排序 👍 104 👎 0


package com.jue.java.learn.leetcode.editor.cn.PowerOfHeroes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JUE
 * @number 2681
 */
public class PowerOfHeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfPower(new int[]{2, 1, 4}));
        System.out.println(solution.sumOfPower(new int[]{1, 1, 1}));
        System.out.println(solution.sumOfPower(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solution.sumOfPower(new int[]{76, 24, 96, 82, 97})); // 13928461
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int sumOfPower(int[] nums) {
        // 的确是一个很完美的排序
        int len = nums.length;
        Arrays.sort(nums);
        // 暴力遍历, 最大值确定了
        long result = 0;
        for (int i = len - 1; i >= 0; i--) {
            long max = (long) (((long) nums[i] * nums[i]) % (10E9 + 7));
            long min = nums[i];
            for (int c = 1; c <= i; c++) {
                min = (long) ((min + (double) (nums[i - c] * countA(c - 1))) % (10E9 + 7));
            }
            result = (long) ((max * min + result) % (10E9 + 7));
        }
        return (int) result;
    }


    /**
     * 阶乘结果
     */
    public static final Map<Integer, Integer> A = new HashMap<>();

    // bug 以为计算阶乘 实际上不是 c(1) = 2 & 1! = 1; c(2) = 4 & 2! = 2; c(3) = 8 & 3! = 6; c(4) = 16 & 4! = 24
    private int countA(int n) {
        if (n == 0) {
            return 1;
        }
        if (A.containsKey(n)) {
            return A.get(n);
        }
        int result = (int) ((countA(n - 1) * 2) % (10E9 + 7));
        A.put(n, result);
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
