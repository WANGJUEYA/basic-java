//给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨： 
//
// 
// 你挑选 任意 一块披萨。 
// Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。 
// Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。 
// 重复上述过程直到没有披萨剩下。 
// 
//
// 每一块披萨的大小按顺时针方向由循环数组 slices 表示。 
//
// 请你返回你可以获得的披萨大小总和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：slices = [1,2,3,4,5,6]
//输出：10
//解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小
//为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
// 
//
// 示例 2： 
//
// 
//
// 输入：slices = [8,9,8,6,1,1]
//输出：16
//解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
// 
//
// 示例 3： 
//
// 输入：slices = [4,1,2,5,8,3,1,9,7]
//输出：21
// 
//
// 示例 4： 
//
// 输入：slices = [3,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= slices.length <= 500 
// slices.length % 3 == 0 
// 1 <= slices[i] <= 1000 
// 
// Related Topics 动态规划


package com.jue.java.learntest.leetcode.editor.cn.PizzaWith3nSlices;

/**
 * @author JUE
 * @number 1388
 */
public class PizzaWith3nSlices {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 打家劫舍环形版
    public int maxSizeSlices(int[] slices) {
        int len = slices.length;
        if (len <= 0) {
            return 0;
        }
        if (len == 1) {
            return slices[0];
        }
        if (len <= 3) {
            int max = 0;
            for (int s : slices) {
                max = Math.max(max, s);
            }
            return max;
        }
        return Math.max(maxSizeSlices(slices, 0, len - 2, len), maxSizeSlices(slices, 1, len - 1, len));
    }

    public int maxSizeSlices(int[] slices, int indexBegin, int indexEnd, int len) {
        int[] preMax = slices;
        int[] currentMax;
        int pmax, cmax = 0;
        for (int i = 1, n = len / 3; i < n; i++) {
            currentMax = new int[len];
            pmax = 0;
            cmax = 0;
            for (int j = indexBegin; j <= indexEnd; j++) {
                cmax = Math.max(cmax, (currentMax[j] = pmax + slices[j]));
                if (j > indexBegin) {
                    pmax = Math.max(pmax, preMax[j - 1]);
                }
            }
//            System.out.println(Arrays.toString(currentMax));
            preMax = currentMax;
        }
        return cmax;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
