//给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。 
//
// 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。 
//
// 返回礼盒的 最大 甜蜜度。 
//
// 
//
// 示例 1： 
//
// 
//输入：price = [13,5,1,8,21,2], k = 3
//输出：8
//解释：选出价格分别为 [13,5,21] 的三类糖果。
//礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
//可以证明能够取得的最大甜蜜度就是 8 。
// 
//
// 示例 2： 
//
// 
//输入：price = [1,3,1], k = 2
//输出：2
//解释：选出价格分别为 [1,3] 的两类糖果。 
//礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
//可以证明能够取得的最大甜蜜度就是 2 。
// 
//
// 示例 3： 
//
// 
//输入：price = [7,7,7,7], k = 2
//输出：0
//解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= price.length <= 10⁵ 
// 1 <= price[i] <= 10⁹ 
// 2 <= k <= price.length 
// 
//
// Related Topics 数组 二分查找 排序 👍 115 👎 0


package com.jue.java.learn.leetcode.editor.cn.MaximumTastinessOfCandyBasket;

import java.util.Arrays;

/**
 * @author JUE
 * @number 2517
 */
public class MaximumTastinessOfCandyBasket {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumTastiness(new int[]{13, 5, 1, 8, 21, 2}, 3));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumTastiness(int[] price, int k) {
        // 二分查找: k个不必从头和尾向中逼近，从一侧找到足够多的即可
        Arrays.sort(price);
        int h = price[price.length - 1] - price[0];
        int l = 0;
        while (l < h) {
            int mid = (l + h + 1) / 2;
            if (check(price, k, mid)) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    public boolean check(int[] price, int k, int mid) {
        int count = 1;
        int last = price[0];
        for (int index = 1, n = price.length; index < n; index++) {
            if (price[index] - last >= mid) {
                if (++count >= k) {
                    return true;
                }
                last = price[index];
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
