//给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
//
// 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
//
//
// 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
// 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
//
//
// 然后将 arr 赋值给 perm 。
//
// 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
//
//
//
// 示例 1：
//
//
//输入：n = 2
//输出：1
//解释：最初，perm = [0,1]
//第 1 步操作后，perm = [0,1]
//所以，仅需执行 1 步操作
//
// 示例 2：
//
//
//输入：n = 4
//输出：2
//解释：最初，perm = [0,1,2,3]
//第 1 步操作后，perm = [0,2,1,3]
//第 2 步操作后，perm = [0,1,2,3]
//所以，仅需执行 2 步操作
//
// 示例 3：
//
//
//输入：n = 6
//输出：4
//
//
//
//
// 提示：
//
//
// 2 <= n <= 1000
// n 是一个偶数
//
//
// Related Topics 数组 数学 模拟 👍 60 👎 0


package com.jue.java.learn.leetcode.editor.cn.MinimumNumberOfOperationsToReinitializeAPermutation;

import java.util.Arrays;

/**
 * @author JUE
 * @number 1806
 */
public class MinimumNumberOfOperationsToReinitializeAPermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // 1, 2, 4, 3, 6, 10, 12, 4, 8, 18, 6, 11, 20, 18, 28
        for (int index = 0; index < 100; index += 2) {
            System.out.println(index + " >>> " + solution.reinitializePermutation(index)); // 1
        }
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reinitializePermutation(int n) {
        // n一定是偶数
        if (n % 2 != 0) {
            throw new IllegalArgumentException("n must even");
        }
        // 先用模拟法进行计算
        return reinitializePermutationMock(n);
        // 公式法计算
        // return reinitializePermutationFormula(n);
    }

    private int reinitializePermutationFormula(int n) {
        return 1; // TODO
    }

    private int reinitializePermutationMock(int n) {
        // 先用模拟法进行计算
        int count = 0;
        int[] init = new int[n];
        int[] perm = new int[n];
        for (int index = 0; index < n; index++) {
            init[index] = index;
            perm[index] = index;
        }
        do {
            count++;
            int[] arr = new int[n];
            for (int index = 0; index < n; index++) {
                if (index % 2 == 0) {
                    arr[index] = perm[index / 2];
                } else {
                    arr[index] = perm[n / 2 + (index - 1) / 2];
                }
            }
            // System.out.println(count + " >>>> " + Arrays.toString(arr));
            perm = arr;
        } while (!Arrays.equals(init, perm));
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
