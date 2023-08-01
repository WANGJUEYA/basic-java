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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author JUE
 * @number 2681
 */
public class PowerOfHeroes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumOfPower(new int[]{2, 1, 4}));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 0 存储大值 1存储小值
    long[][][] store;

    public int sumOfPower(int[] nums) {
        // 的确是一个很完美的排序
        List<int[]> sort = new ArrayList<>();
        int len = nums.length;
        for (int idx = 0; idx < len; idx++) {
            sort.add(new int[]{nums[idx], idx});
        }
        sort.sort(Comparator.comparingInt(item -> item[0]));
        store = new long[len][len][2];
        // 明显有树的样子了！
        treeMax(sort, 0, len - 1);
        treeMin(sort, 0, len - 1);
        long result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                result = (long) ((store[i][j][0] * store[i][j][1] + result) % (10e9 + 7));
            }
        }
        return (int) result;
    }

    private void treeMax(List<int[]> sort, int begin, int end) {
        if (sort.isEmpty()) {
            return;
        }
        int len = sort.size();
        int[] single = sort.get(len - 1);
        long current = (long) (((long) single[0] * single[0]) % (10e9 + 7));
        for (int i = begin; i <= single[1]; i++) {
            for (int j = single[1]; j <= end; j++) {
                store[i][j][0] = current;
            }
        }
        if (begin == end) {
            assert sort.size() == 1;
            return;
        }
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        for (int idx = 0; idx < len - 1; idx++) {
            if (sort.get(idx)[1] < single[1]) {
                left.add(sort.get(idx));
            } else {
                right.add(sort.get(idx));
            }
        }
        treeMax(left, begin, single[1] - 1);
        treeMax(right, single[1] + 1, end);
    }

    private void treeMin(List<int[]> sort, int begin, int end) {
        if (sort.isEmpty()) {
            return;
        }
        int[] single = sort.get(0);
        for (int i = begin; i <= single[1]; i++) {
            for (int j = single[1]; j <= end; j++) {
                store[i][j][1] = single[0];
            }
        }
        if (begin == end) {
            assert sort.size() == 1;
            return;
        }
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        for (int idx = 1, len = sort.size(); idx < len; idx++) {
            if (sort.get(idx)[1] < single[1]) {
                left.add(sort.get(idx));
            } else {
                right.add(sort.get(idx));
            }
        }
        treeMin(left, begin, single[1] - 1);
        treeMin(right, single[1] + 1, end);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
