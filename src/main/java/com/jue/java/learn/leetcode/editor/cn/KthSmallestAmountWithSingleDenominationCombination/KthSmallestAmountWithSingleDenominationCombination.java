//给你一个整数数组 coins 表示不同面额的硬币，另给你一个整数 k 。 
//
// 你有无限量的每种面额的硬币。但是，你 不能 组合使用不同面额的硬币。 
//
// 返回使用这些硬币能制造的 第 kᵗʰ 小 金额。 
//
// 
//
// 示例 1： 
//
// 
// 输入： coins = [3,6,9], k = 3 
// 
//
// 输出： 9 
//
// 解释：给定的硬币可以制造以下金额： 3元硬币产生3的倍数：3, 6, 9, 12, 15等。 6元硬币产生6的倍数：6, 12, 18, 24等。 9元硬
//币产生9的倍数：9, 18, 27, 36等。 所有硬币合起来可以产生：3, 6, 9, 12, 15等。 
//
// 示例 2： 
//
// 
// 输入：coins = [5,2], k = 7 
// 
//
// 输出：12 
//
// 解释：给定的硬币可以制造以下金额： 5元硬币产生5的倍数：5, 10, 15, 20等。 2元硬币产生2的倍数：2, 4, 6, 8, 10, 12等。 
//所有硬币合起来可以产生：2, 4, 5, 6, 8, 10, 12, 14, 15等。 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 15 
// 1 <= coins[i] <= 25 
// 1 <= k <= 2 * 10⁹ 
// coins 包含两两不同的整数。 
// 
//
// Related Topics 位运算 数组 数学 二分查找 组合数学 数论 👍 11 👎 0


package com.jue.java.learn.leetcode.editor.cn.KthSmallestAmountWithSingleDenominationCombination;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author JUE
 * @number 3116
 */
public class KthSmallestAmountWithSingleDenominationCombination {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthSmallest(new int[]{3, 6, 9}, 3)); // 9
        System.out.println(solution.findKthSmallest(new int[]{3, 6, 9}, 7)); // 21
        System.out.println(solution.findKthSmallest(new int[]{5, 2}, 7)); // 12
        System.out.println(solution.findKthSmallest(new int[]{5}, 7)); // 35
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        if (coins.length == 1) {
            return (long) coins[0] * k;
        }
        // 二分查找 + 容斥定理 + 预处理;
        long[] lcm = new long[1 << coins.length];
        lcm[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            // 表示有多少种集合算法，位数为1表示该组集合参与运算
            int bit = 1 << i;
            for (int mask = 0; mask < bit; mask++) {
                //刷表法 DP，在集合 mask 的基础上添加元素 i
                lcm[bit | mask] = lcm(lcm[mask], coins[i]);
            }
        }
        for (int i = 1; i < lcm.length; i++) {
            if (Integer.bitCount(i) % 2 == 0) {
                lcm[i] *= -1;
            }
        }

        long left = k - 1;
        long right = (long) coins[0] * k;
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            if (check(mid, lcm, k)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    // 检查数量是否足够
    private boolean check(long m, long[] subsetLcm, int k) {
        long cnt = 0;
        for (int i = 1; i < subsetLcm.length; i++) { // 枚举所有非空子集
            cnt += m / subsetLcm[i];
        }
        return cnt >= k;
    }

    protected long count(int a, int b, int m) {
        return m / a + m / b - m / lcm(a, b);
    }

    /**
     * 计算两个数的最小公倍数
     */
    protected long lcm(long a, long b) {
        // lcm(a,b) = (a*b)/gcd(a,b);
        // 辗转相除法求gcd
        return (a * b) / gcd(a, b);
    }

    /**
     * 最大公约数: 辗转相除法
     */
    protected long gcd(long a, long b) {
        if (a < b) {
            return gcd(b, a);
        }
        long mod = a % b;
        if (mod == 0) {
            return b;
        }
        return gcd(b, mod);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

class Solution_Timeout {
    public long findKthSmallest(int[] coins, int k) {
        // 分布式思想，优先队列，每次取最小的，取完之后放入其下一个次序：
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing(ints -> ints[0]));
        for (int coin : coins) {
            queue.add(new int[]{coin, coin, 1});
        }
        int result = -1;
        // 需要忽略重复数字
        while (k > 0) {
            while (true) {
                int[] min = queue.poll();
                int count = min[2] + 1;
                queue.add(new int[]{min[1] * count, min[1], count});
                if (min[0] > result) {
                    result = min[0];
                    break;
                }
            }
            k--;
        }
        return result;
    }
}
